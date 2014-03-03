package com.ebay.gatling

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {

	val props = new GatlingPropertiesBuilder
	props.dataDirectory("src/main/resources/data")
	props.requestBodiesDirectory("src/main/resources/request-bodies")
  props.resultsDirectory("target/results")
  props.binariesDirectory("target/scala-2.10/classes")

	Gatling.fromMap(props.build)
}