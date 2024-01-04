package nur.xan.neocafe.clientneocafe.models.order.create

data class Order(
    val minusBonus: Double,
    val orderDate: String,
    val orderDetails: List<Any>,
    val orderEndDate: Any,
    val orderId: Int,
    val orderStatus: String,
    val price: Double,
    val ready: Boolean,
    val table: Any,
    val user: User
)