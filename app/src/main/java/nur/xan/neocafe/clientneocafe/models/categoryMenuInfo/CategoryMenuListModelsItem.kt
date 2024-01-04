package nur.xan.neocafe.clientneocafe.models.categoryMenuInfo

data class CategoryMenuListModelsItem(
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