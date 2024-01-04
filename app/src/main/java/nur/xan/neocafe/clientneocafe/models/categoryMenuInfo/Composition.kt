package nur.xan.neocafe.clientneocafe.models.categoryMenuInfo

data class Composition(
    val compositionId: Int,
    val items: List<Item>,
    val quantity: Double,
    val unit: String
)