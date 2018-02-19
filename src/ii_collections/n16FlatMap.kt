package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // JJJ: orders is from the customer data class.  it is List<Order>
    // an Order is a List<Product> plus flag isDelivered
    // Because each Order contains a List<Product>, we want to
    // iterate each Order, extracting the list of products
    // and making one combined list of products from all the orders.
    // This combined list is called a FlatMap
    //
    return orders.flatMap { it.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    return this.customers.flatMap { it.orderedProducts }.toSet()
}
