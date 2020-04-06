package com.example

object Checkout {

  type Item  = String
  type Price = BigDecimal

  val priceMap = Map("Apple" -> BigDecimal(0.60), "Orange" -> BigDecimal(0.25))

  def checkout(items: List[Item]): Price = {
    val itemToCount =
      items
        .groupBy(identity)
        .view
        .mapValues(_.length)
        .toMap

    itemToCount.foldLeft(BigDecimal(0)) {
      case (acc, (item, count)) =>
        // We assume there is always a for a given item
        acc + priceMap(item) * count
    }
  }

}
