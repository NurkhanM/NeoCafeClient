package nur.xan.neocafe.clientneocafe.models.filial

data class MenuProduct(
    val categories: Categories,
    val compositions: List<Composition>,
    val description: String,
    val dopings: List<Doping>,
    val filial: String,
    val hasAdditional: Boolean,
    val image: String,
    val name: String,
    val price: Int,
    val product_id: Int
)