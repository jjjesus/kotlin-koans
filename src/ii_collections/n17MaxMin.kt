package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders() = this.customers.maxBy { it.orders.count() }

fun Customer.getMostExpensiveOrderedProduct() = this.orderedProducts.maxBy { it.price }
