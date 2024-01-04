package nur.xan.neocafe.clientneocafe.models.filial

data class Composition(
    val composition_id: Int,
    val items: List<Item>,
    val menuProduct: String,
    val quantity: Int,
    val unit: String
)