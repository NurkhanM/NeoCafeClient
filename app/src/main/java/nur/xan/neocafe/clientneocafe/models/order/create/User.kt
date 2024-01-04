package nur.xan.neocafe.clientneocafe.models.order.create

data class User(
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val authorities: List<Authority>,
    val birthDate: String,
    val bonus: Double,
    val credentialsNonExpired: Boolean,
    val enabled: Boolean,
    val firstName: String,
    val lastName: Any,
    val login: Any,
    val password: Any,
    val phoneNumber: String,
    val role: String,
    val user_id: Int,
    val username: String,
    val verificationCodes: List<Any>,
    val workingTime: Any
)