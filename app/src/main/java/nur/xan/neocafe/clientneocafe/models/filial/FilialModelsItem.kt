package nur.xan.neocafe.clientneocafe.models.filial

data class FilialModelsItem(
    val closingTime: ClosingTime,
    val filialId: Int,
    val filialInfo: FilialInfo,
    val `open`: Boolean,
    val openingTime: OpeningTime,
    val timeLeft: String
)