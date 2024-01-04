package nur.xan.neocafe.clientneocafe.models.order.create

data class OrderCreateModels(
    val bonusPlus: Any,
    val finalPrice: Double,
    val isSucceed: Boolean,
    val message: String,
    val order: Order
)