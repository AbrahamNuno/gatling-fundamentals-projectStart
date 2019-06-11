package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseSimulation extends Simulation {
  val httpConf = http
    .baseURL("http://172.16.0.101:8686/app/")
    .header("Accept", "application/json")
//    .proxy(Proxy("localhost", 8888).httpsPort(8888))  // This is to capture traffic, useful for debugging

}