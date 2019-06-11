package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class BasicLoadSimulation extends BaseSimulation {

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
      nothingFor(5 seconds),  // The first 5 seconds no users will be injected
      atOnceUsers(5),
      rampUsers(10) over(10)
    )
  ).protocols(httpConf.inferHtmlResources())
}
