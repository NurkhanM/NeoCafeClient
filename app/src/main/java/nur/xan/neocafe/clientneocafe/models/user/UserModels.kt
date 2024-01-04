package nur.xan.neocafe.clientneocafe.models.user

data class UserModels(
    val clientProfileDto: ClientProfileDto,
    val isSucceed: Boolean,
    val message: Any,
    val token: Any
)