package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseCode extends BaseSimulation {

  // 1 Common HTTP Configuration
  // This part is defined in the BaseSimulation.scala class

  // 2 Scenario Definition
  val scn = scenario("Video Game DB")

    .exec(http("Get All Games - 1st call")
        .get("videogames")
        .check(status.is(200)))

    .exec(http("Get specific game")
      .get("videogames/1")
      .check(status.in(200 to 210)))

    .exec(http("Get All Games - 2nd call")
      .get("videogames")
      .check(status.not(404), status.not(500)))

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
