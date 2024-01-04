package nur.xan.neocafe.clientneocafe.models.order.cancel

data class OrderCancelModels(
    val bonusPlus: Any,
    val finalPrice: Any,
    val isSucceed: Boolean,
    val message: String,
    val order: Any
)