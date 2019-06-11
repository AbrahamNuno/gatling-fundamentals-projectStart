package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CsvFeeder extends BaseSimulation {

  // We declare a csvFeeder variable that point to our csv data file
  val csvFeeder = csv("gameCsvFile.csv").circular  // Circular strategy takes the values of the feeder in their order, and when it reaches the last, it returns to the first one.

  // 1 Common HTTP Configuration
  // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  def getSpecificVideoGame() = {
    repeat(17) {
      feed(csvFeeder)
        .exec(http("Get Specific Video Game")
        .get("videogames/${gameId}")    // gameId parameter will be taken from the csv feeder file
        .check(jsonPath("$.name").is("${gameName}"))  // gameName parameter will be taken from the csv feeder file
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody")))                            // Saves the response body into responseBody param
        .exec { session => println(session("responseBody").as[String]); session }   // Extracts the responseBody and prints it to the output
        .pause(1)
    }
  }

  val scn = scenario("Video Game DB")
    .exec(getSpecificVideoGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
