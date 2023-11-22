package nur.xan.neocafe.clientneocafe.models.allCategory

data class AllCategoryModelsItem(
    val category_id: Int,
    val image: String,
    val menuProducts: List<MenuProduct>,
    val name: String
)