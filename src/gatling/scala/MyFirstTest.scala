import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

//class MyFirstTest extends Simulation {
class MyFirstTest extends BaseSimulation {

  // 1 Common HTTP Configuration
//  val httpConf = http
//    .baseURL("http://172.16.0.101:8686/app/")
//    .header("Accept", "application/json")

  // 2 Scenario Definition
  val scn = scenario("My First Test")
    .exec(http("Get All Games")
    .get("videogames"))

  // 3 Load Scenario
  setUp(scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
