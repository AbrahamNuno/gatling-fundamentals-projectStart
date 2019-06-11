package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CsvFeederToCustom extends BaseSimulation {

  val idNumbers = (1 to 10).iterator
//  val customFeeder = Iterator.continually(Map("gameId" -> idNumbers.next()))

  def getNextGameId() = Map("gameId" -> idNumbers.next())
  val customFeeder = Iterator.continually(getNextGameId())

  def getSpecificVideoGame() = {
    repeat(10) {
      feed(customFeeder)
        .exec(http("Get Specific Video Game")
        .get("videogames/${gameId}")    // gameId parameter will be taken from the csv feeder file
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody")))                            // Saves the response body into responseBody param
        .exec { session => println(session("responseBody").as[String]); session }   // Extracts the responseBody and prints it to the output
        .pause(1)
    }
  }

  // 1 Common HTTP Configuration
  // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  val scn = scenario("Video Game DB")
    .exec(getSpecificVideoGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
