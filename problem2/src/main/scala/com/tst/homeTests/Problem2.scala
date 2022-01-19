package com.tst.homeTests

import com.tst.homeTests.models._

object Problem2 {
  def main(args: Array[String]) : Unit = {
    println("Running solution for Problem2")

    val P1 = "P1"
    val P2 = "P2"
    val P3 = "P3"
    val P4 = "P4"
    val P5 = "P5"

    val test1 = Seq(
      Promotion(P1, Seq(P3)),
      Promotion(P2, Seq(P4, P5)),
      Promotion(P3, Seq(P1)),
      Promotion(P4, Seq(P2)),
      Promotion(P5, Seq(P2))
    )

    val allCombinations1 = allCombinablePromotions(test1)
    for (combination <- allCombinations1) {
      println(combination)
    }

  }
}