package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class RunParallelScenarios extends BaseSimulation {

  def getAllVideoGames() = {
    exec(http("Get All Video Games")
      .get("videogames")
      .check(status.is(200)))
  }

  def getSpecificVideoGame() = {
    exec(http("Get Specific Video Game")
      .get("videogames/2")
      .check(status.is(200)))
  }

  val scn1 = scenario("Video Game DB - Get All Video Games")
    .forever() {  // forever() makes each user run the scenario again and again until duration time
      exec(getAllVideoGames())
        .pause(2)
    }

  val scn2 = scenario("Video Game DB - Get Specific Video Game")
      .forever() {
        exec(getSpecificVideoGame())
          .pause(2)
      }


  setUp(
    scn1.inject(
      nothingFor(5 seconds),
      rampUsers(30) over(15 seconds)),

    scn2.inject(
      nothingFor(10 seconds),
      rampUsers(5) over(10 seconds))
  ).protocols(httpConf.inferHtmlResources()).maxDuration(1 minute)
}
