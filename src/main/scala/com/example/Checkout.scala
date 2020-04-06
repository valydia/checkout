package com.example

object Checkout {

  type Price = BigDecimal

  trait Item {
    val name: String
    val price: Price
    val discountQuantity: Int
    val discountedPrice: Price
  }
  case object Apple extends Item {
    override val name: String           = "Apple"
    override val price: Price           = BigDecimal(0.60)
    override val discountQuantity: Int  = 2
    override val discountedPrice: Price = price
  }

  case object Orange extends Item {
    override val name: String           = "Orange"
    override val price: Price           = BigDecimal(0.25)
    override val discountQuantity: Int  = 3
    override val discountedPrice: Price = 2 * price
  }
  object Item {
    def fromString(string: String): Option[Item] =
      string match {
        case "Apple"  => Some(Apple)
        case "Orange" => Some(Orange)
        case _        => None
      }
  }

  def checkout(items: List[String]): Price = {
    val itemToCount =
      items
        .groupBy(Item.fromString)
        .collect { case (Some(item), list) => item -> list.length } // Discard invalid input

    itemToCount.foldLeft(BigDecimal(0)) {
      case (acc, (item, count)) =>
        val appliedDiscountPrice = (count / item.discountQuantity) * item.discountedPrice
        val notDiscountedPrice   = (count % item.discountQuantity) * item.price
        val itemPrice            = appliedDiscountPrice + notDiscountedPrice
        acc + itemPrice
    }
  }

}
