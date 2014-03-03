package com.ebay.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimGet extends Simulation {
  val req = http("_http1").get("http://localhost:8000")

  val onceScn = scenario("once").exec(req)

  val atOnceInj = atOnce(1 users)

  setUp(onceScn.inject(atOnceInj))
}
