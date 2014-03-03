package com.ebay.gatling

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {
  def apply(cls: Class[_]) = {
    val props = new GatlingPropertiesBuilder

    props.resultsDirectory("target/results")
    props.binariesDirectory("target/scala-2.10/classes")
    props.simulationClass(cls.getName)

    Gatling.fromMap(props.build)
  }
}
