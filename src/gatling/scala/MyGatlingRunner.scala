import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.{AddPauseTime, CheckResponseBodyAndExtract, CheckResponseCode, CodeReuseWithObjects, CsvFeeder, CsvFeederToCustom, CustomFeeder, BasicLoadSimulation, RampUsersLoadSimulation, FixedDurationLoadSimulation, RunParallelScenarios}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

//    val simClass = classOf[MyFirstTest].getName
//    val simClass = classOf[AddPauseTime].getName
//    val simClass = classOf[CheckResponseCode].getName
//    val simClass = classOf[CheckResponseBodyAndExtract].getName
//    val simClass = classOf[CodeReuseWithObjects].getName
//    val simClass = classOf[CsvFeeder].getName
//    val simClass = classOf[CsvFeederToCustom].getName
//    val simClass = classOf[CustomFeeder].getName
//    val simClass = classOf[BasicLoadSimulation].getName
//    val simClass = classOf[RampUsersLoadSimulation].getName
//    val simClass = classOf[FixedDurationLoadSimulation].getName
    val simClass = classOf[RunParallelScenarios].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
