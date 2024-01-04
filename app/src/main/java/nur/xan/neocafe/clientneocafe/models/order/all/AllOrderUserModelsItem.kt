package nur.xan.neocafe.clientneocafe.models.order.all

data class AllOrderUserModelsItem(
    val filialImage: Any,
    val filialName: String,
    val menuProductName: String,
    val orderDate: String,
    val orderStatus: String,
    val ready: Boolean
)