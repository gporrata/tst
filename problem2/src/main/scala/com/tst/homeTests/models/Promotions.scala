package com.tst.homeTests.models

case class Promotion(
  code: String,
  notCombinableWith: Seq[String])

case class PromotionCombo(
  promotionCodes: Seq[String]
)