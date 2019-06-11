package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyAndExtract extends BaseSimulation {

  // 1 Common HTTP Configuration
  // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  val scn = scenario("Video Game DB")

    .exec(http("Get specific game")
        .get("videogames/1")
        .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("Get All Video Games")
        .get("videogames")
        .check(jsonPath("$[1].id").saveAs("gameId")))
    .exec { session => println(session); session }    // Extracts the session and prints it to the output

    .exec(http("Get specfic game - with parameter")
        .get("videogames/${gameId}")
        .check(jsonPath("$.name").is("Gran Turismo 3"))
    .check(bodyString.saveAs("responseBody")))                            // Saves the response body into responseBody param
    .exec { session => println(session("responseBody").as[String]); session }   // Extracts the responseBody and prints it to the output

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
