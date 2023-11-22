package nur.xan.neocafe.clientneocafe.models.allCategory

data class MenuProduct(
    val categories: String,
    val compositions: List<Composition>,
    val description: String,
    val filial: FilialX,
    val hasAdditional: Boolean,
    val image: String,
    val name: String,
    val price: Int,
    val product_id: Int
)