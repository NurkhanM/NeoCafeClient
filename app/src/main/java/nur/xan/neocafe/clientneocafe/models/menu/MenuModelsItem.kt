package nur.xan.neocafe.clientneocafe.models.menu

data class MenuModelsItem(
    val categoryId: Int,
    val compositions: List<Composition>,
    val description: String,
    val dopings: Any,
    val filialId: Int,
    val hasAdditional: Boolean,
    val image: Any,
    val name: String,
    val price: Double,
    val productId: Int
)