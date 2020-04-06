package com.example

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers

class CheckoutSpec extends AnyFeatureSpec with Matchers with GivenWhenThen {

  Feature("Checkout") {

    Scenario("0 - Shopping Cart - with empty list") {
      Given("A list of items []")
      val items = List()

      When("Calculating the total cost")
      val result = Checkout.checkout(items)

      Then("The total coast should be £0")
      result shouldBe 0
    }

    Scenario("1 - Shopping Cart") {
      Given("A list of items [ Apple, Apple, Orange, Apple ]")
      val items = List("Apple", "Apple", "Orange", "Apple")

      When("Calculating the total cost")
      val result = Checkout.checkout(items)

      Then("The total coast should be £1.45")
      result shouldBe 1.45
    }

    Scenario("2 - Simple offers") {
      Given(
        "A list of items [ Apple, Apple, Orange, Apple, Orange, Orange, Apple, Orange ]"
      )
      val items = List(
        "Apple",
        "Apple",
        "Orange",
        "Apple",
        "Orange",
        "Orange",
        "Apple",
        "Orange"
      )

      When("Calculating the total cost")
      val result = Checkout.checkout(items)

      Then("The total coast should be £1.95")
      result shouldBe 1.95
    }

  }

}
