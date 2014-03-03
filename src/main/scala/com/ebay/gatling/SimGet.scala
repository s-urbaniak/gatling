package com.ebay.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimGet extends Simulation {
  val req = http("_http1").get("http://localhost:8000")
  val once = scenario("once").exec(req)
  val oneUser = atOnce(1 users)

  setUp(once inject oneUser)
}

object SimGet extends App {
  Engine(classOf[SimGet])
}
