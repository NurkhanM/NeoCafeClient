package nur.xan.neocafe.clientneocafe.models.allCategory

data class User(
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val authorities: List<Authority>,
    val birthDate: String,
    val credentialsNonExpired: Boolean,
    val enabled: Boolean,
    val filial: String,
    val firstName: String,
    val lastName: String,
    val login: String,
    val password: String,
    val phoneNumber: String,
    val role: String,
    val user_id: Int,
    val username: String,
    val verificationCodes: List<VerificationCode>,
    val workingTime: WorkingTimeX
)