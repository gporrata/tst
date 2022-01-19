package com.tst.homeTests

import com.tst.homeTests.models._

object Problem1 {
  def main(args: Array[String]) : Unit = {
    println("Running solution for Problem1")

    val M1 = "M1"
    val M2 = "M2"
    val Military = "Military"
    val Senior = "Senior"
    val CA = "CA"
    val CB = "CB"
    val S1 = "S1"
    val S2 = "S2"

    val rates = Seq(
      Rate(M1, Military),
      Rate(M2, Military),
      Rate(S1, Senior),
      Rate(S2, Senior)
    )
    val cabinPrices = Seq(
      CabinPrice(CA, M1, 200.00),
      CabinPrice(CA, M2, 250.00),
      CabinPrice(CA, S1, 225.00),
      CabinPrice(CA, S2, 260.00),
      CabinPrice(CB, M1, 230.00),
      CabinPrice(CB, M2, 260.00),
      CabinPrice(CB, S1, 245.00),
      CabinPrice(CB, S2, 270.00)
    )

    val bestGroupPrices = getBestGroupPrices(rates, cabinPrices)
      .sortBy(_.price)
      .sortBy(_.cabinCode)
    for(bestGroupPrice <- bestGroupPrices) {
      println(bestGroupPrice)
    }
  }
}
