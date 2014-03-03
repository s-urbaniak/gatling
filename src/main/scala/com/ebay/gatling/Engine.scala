package com.ebay.gatling

import io.gatling.core.config.GatlingPropertiesBuilder
import io.gatling.app.Gatling

object Engine {
  def apply(cls: Class[_]) = {
    val props = new GatlingPropertiesBuilder

    props.resultsDirectory("target/results")
    props.binariesDirectory("target/scala-2.10/classes")
    props.simulationClass(cls.getName)

    Gatling.fromMap(props.build)
  }
}
