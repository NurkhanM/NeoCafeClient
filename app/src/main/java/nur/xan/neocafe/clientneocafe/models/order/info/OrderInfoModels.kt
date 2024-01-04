package nur.xan.neocafe.clientneocafe.models.order.info

data class OrderInfoModels(
    val filialName: String,
    val menuProducts: List<Any>,
    val minusBonus: Double,
    val orderDate: String,
    val order_id: Int,
    val totalPrice: Double
)