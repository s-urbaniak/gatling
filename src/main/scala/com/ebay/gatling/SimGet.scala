package com.ebay.gatling

import io.gatling.core.Predef._
import io.gatling.core.Predef.bootstrap._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationDouble

class SimGet extends Simulation {
  // single unit
  val req = http("SimGet").get("http://localhost:8000")

  // scenarios
  val onceScn = scenario("once").exec(req)
  val timedScn = scenario("timed").during(5 seconds) { exec(req) }
  val iteratedScn = scenario("iterated").repeat(1000) { exec(req) }

  // injections
  val atOnceInj = atOnce(1 users)
  val constInj = constantRate(3 usersPerSec) during (3 seconds)
  val rampInj = ramp(15 users) over (5 seconds)
  val rampRateInj = rampRate(1 usersPerSec) to (3 usersPerSec) during (3 seconds)

  // setup
  setUp(onceScn inject atOnceInj)
}

object SimGet extends App {
  Engine(classOf[SimGet])
}
