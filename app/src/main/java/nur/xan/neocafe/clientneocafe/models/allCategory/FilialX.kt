package nur.xan.neocafe.clientneocafe.models.allCategory

data class FilialX(
    val address: String,
    val filial_id: Int,
    val image: String,
    val mapLink: String,
    val menuProducts: List<String>,
    val name: String,
    val `open`: Boolean,
    val phoneNumber: String,
    val users: List<UserX>,
    val workingTime: WorkingTimeX
)