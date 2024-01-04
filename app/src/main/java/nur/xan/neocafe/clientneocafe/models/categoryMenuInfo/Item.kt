package nur.xan.neocafe.clientneocafe.models.categoryMenuInfo

data class Item(
    val itemId: Int,
    val name: String,
    val quantity: Double,
    val stockCategory: Any,
    val unit: String
)