package com.tst.homeTests

import com.tst.homeTests.models._

object Problem2 {
  final val GREEN = "\u001B[32m"
  final val RESET = "\u001B[0m"

  def main(args: Array[String]) : Unit = {
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

    println(s"${GREEN}Running solution for Problem 2.1${RESET}")
    val allCombinations1 = allCombinablePromotions(test1)
    for (combination <- allCombinations1) {
      println(combination)
    }

    println(s"${GREEN}Running solution for Problem 2.2${RESET}")
    val allCombinations2 = combinablePromotions(P1, test1)
    for (combination <- allCombinations2) {
      println(combination)
    }

    println(s"${GREEN}Running solution for Problem 2.3${RESET}")
    val allCombinations3 = combinablePromotions(P3, test1)
    for (combination <- allCombinations3) {
      println(combination)
    }
  }
}