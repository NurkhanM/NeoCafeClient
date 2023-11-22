package nur.xan.neocafe.clientneocafe.models.allCategory

data class Filial(
    val address: String,
    val filial_id: Int,
    val image: String,
    val mapLink: String,
    val menuProducts: List<String>,
    val name: String,
    val `open`: Boolean,
    val phoneNumber: String,
    val users: List<User>,
    val workingTime: WorkingTimeX
)