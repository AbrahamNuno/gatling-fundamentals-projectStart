package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class AddPauseTime extends BaseSimulation {

  // 1 Common HTTP Configuration
      // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  val scn = scenario("Video Game DB")

    .exec(http("Get All Video Games - 1st call")
        .get("videogames"))
        .pause(5)         // Adds a pause of 5 seconds

    .exec(http("Get specific game")
        .get("videogames/1"))
        .pause(1, 20)              // Adds a random pause between 1 and 20 seconds

    .exec(http("Get All Video Games - 2nd call")
        .get("videogames"))
        .pause(3000.milliseconds)  // Adds a random pause between 1 and 20 seconds

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
