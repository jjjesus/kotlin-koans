package ii_collections

fun example6() {
    listOf(1, 3).sum() == 4
    listOf("a", "b", "cc").sumBy { it.length } == 4
}

fun Customer.getTotalOrderPrice() = this.orders.flatMap { it.products }.sumByDouble { ii -> ii.price }
