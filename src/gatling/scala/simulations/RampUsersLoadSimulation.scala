package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class RampUsersLoadSimulation extends BaseSimulation {

  def getAllVideoGames() = {
    exec(http("Get All Videogames")
      .get("videogames")
      .check(status.is(200)))
  }

  def getSpecificVideoGame() = {
    exec(http("Get Specific Videogame")
      .get("videogames/2")
      .check(status.is(200)))
  }

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGame())
    .pause(5)
    .exec(getAllVideoGames())

  setUp(
    scn.inject(
      nothingFor(5 seconds),
//      constantUsersPerSec(10) during(10 seconds)  // Add 10 user per second during 10 seconds = 100 users total
      rampUsersPerSec(1) to(5) during(20 seconds)  // Starts adding 1 user per sec, then increases to 5 per sec, over a period of 20 seconds
    )
  ).protocols(httpConf.inferHtmlResources())
}
