package nur.xan.neocafe.clientneocafe.models.filial

data class Categories(
    val category_id: Int,
    val image: String,
    val menuProducts: List<String>,
    val name: String
)