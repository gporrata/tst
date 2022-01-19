package com.tst.homeTests

package object models {
  // note: 1. fn assumes there is a one-to-one relation between a rate and a rate group
  //   thus when rates are grouped by rateCode there should be a sequence of just one item for its values
  def getBestGroupPrices(rates: Seq[Rate], prices: Seq[CabinPrice]) : Seq[BestGroupPrice] = {
    val rateGroupLookup = rates
      .groupBy(_.rateCode)
      .mapValues(_.head.rateGroup) // see note 1. above
    prices
      .groupBy(p => (p.cabinCode, rateGroupLookup(p.rateCode)))
      .collect {
        case ((cabinCode, rateGroup), cabinPrices) =>
          val CabinPrice(_, rateCode, minPrice) = cabinPrices.minBy(_.price)
          BestGroupPrice(cabinCode, rateCode, minPrice, rateGroup)
    }
      .toSeq
  }
}