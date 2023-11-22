package nur.xan.neocafe.clientneocafe.models.allCategory

data class VerificationCode(
    val code: String,
    val expirationTime: String,
    val id: Int,
    val phoneConfirmedAt: String,
    val phoneNumber: String,
    val user: String
)