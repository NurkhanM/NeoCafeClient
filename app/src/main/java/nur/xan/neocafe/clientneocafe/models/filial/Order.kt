package nur.xan.neocafe.clientneocafe.models.filial

data class Order(
    val filial: String,
    val minusBonus: Int,
    val orderDate: String,
    val orderDetails: List<OrderDetail>,
    val orderEndDate: String,
    val orderId: Int,
    val orderStatus: String,
    val price: Int,
    val ready: Boolean,
    val table: Table,
    val user: User
)