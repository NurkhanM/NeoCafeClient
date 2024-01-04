package nur.xan.neocafe.clientneocafe.models.filial

data class Item(
    val arrivalDate: String,
    val expirationDate: String,
    val filial: String,
    val item_id: Int,
    val minimalLimit: Int,
    val name: String,
    val quantity: Int,
    val stockCategory: String,
    val unit: String
)