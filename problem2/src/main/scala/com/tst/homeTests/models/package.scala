package com.tst.homeTests

package object models {

  def isValidPromotionSet(promotions: Set[Promotion]): Boolean = {
    val allCodes = promotions.map(_.code)
    promotions.forall { _.notCombinableWith.toSet.intersect(allCodes).isEmpty }
  }
  def toPromotionCombo(promotions: Set[Promotion]) = PromotionCombo(promotions.toSeq.map(_.code))
  def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    val emptyListOfPromotions = List.empty[Set[Promotion]]
    allPromotions
      .toSet
      .subsets
      .toList
      .sortBy(0 - _.toList.length)
      .foldLeft(emptyListOfPromotions){ (filteredPromotionCombos, promotions) =>
        if(!filteredPromotionCombos.exists(promotions.subsetOf(_)) && isValidPromotionSet(promotions))
          filteredPromotionCombos :+ promotions
        else
          filteredPromotionCombos
      }
      .map(toPromotionCombo(_))
      .toSeq
  }
  def combinablePromotions(promotionCode: String, allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    allCombinablePromotions(allPromotions).filter { promotionCombo =>
      promotionCombo.promotionCodes.contains(promotionCode)
    }
  }

}