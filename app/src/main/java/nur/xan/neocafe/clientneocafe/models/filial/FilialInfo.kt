package nur.xan.neocafe.clientneocafe.models.filial

data class FilialInfo(
    val address: String,
    val filial_id: Int,
    val image: String,
    val mapLink: String,
    val menuProducts: List<MenuProduct>,
    val name: String,
    val `open`: Boolean,
    val orders: List<Order>,
    val phoneNumber: String,
    val tables: List<TableX>,
    val users: List<UserX>,
    val workingTime: WorkingTimeXX
)