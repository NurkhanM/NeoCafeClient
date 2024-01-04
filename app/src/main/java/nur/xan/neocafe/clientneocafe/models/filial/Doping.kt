package nur.xan.neocafe.clientneocafe.models.filial

data class Doping(
    val doping_id: Int,
    val items: List<Item>,
    val menuProduct: String,
    val price: Int,
    val quantity: Int,
    val unit: String
)