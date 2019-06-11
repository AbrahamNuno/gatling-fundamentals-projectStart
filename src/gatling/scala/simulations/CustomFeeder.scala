package simulations

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class CustomFeeder extends BaseSimulation {

  val idNumbers = (16 to 20).iterator
  val rnd = new Random()
  val now = LocalDate.now()
  val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  // Method to create a random string of the given number length
  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  // Method to create a random date within the last 30 days
  def getRandomDate(startDate: LocalDate, random: Random):String = {
    startDate.minusDays(random.nextInt(30)).format(pattern)
  }

  // Define a customFeeder variable using above 2 methods
  val customFeeder = Iterator.continually(Map(
    "gameId" -> idNumbers.next(),
    "name" -> ("Game-" + randomString(5)),
    "releaseDate" -> getRandomDate(now, rnd),
    "reviewScore" -> rnd.nextInt(100),
    "category" -> ("Category-" + randomString(6)),
    "rating" -> ("Rating-" + randomString(4))
  ))

  // Method to post a new game by using JSON directly in the body
//  def postNewGame() = {
//    repeat(5) {
//      feed(customFeeder)
//        .exec(http("Post New Game")
//        .post("videogames")
//        .body(StringBody(
//          "{" +
//            "\n\t\"id\": \"${gameId}\"," +
//            "\n\t\"name\": \"${name}\"," +
//            "\n\t\"releaseDate\": \"${releaseDate}\"," +
//            "\n\t\"reviewScore\": \"${reviewScore}\"," +
//            "\n\t\"category\": \"${category}\"," +
//            "\n\t\"rating\": \"${rating}\"\n}")
//        ).asJSON
//        .check(status.is(200)))
//        .pause(1)
//    }
//  }

  // Method to post a new game by using JSON template "NewGameTemplate.json"
  def postNewGame() = {
    repeat(5) {
      feed(customFeeder)
        .exec(http("Post New Game")
        .post("videogames")
        .body(ElFileBody("NewGameTemplate.json")).asJSON
        .check(status.is(200)))
        .pause(1)
    }
  }

  // 1 Common HTTP Configuration
  // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  val scn = scenario("Video Game DB")
    .exec(postNewGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
