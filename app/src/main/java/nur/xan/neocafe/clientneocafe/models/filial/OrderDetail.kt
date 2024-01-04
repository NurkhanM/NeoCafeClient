package nur.xan.neocafe.clientneocafe.models.filial

data class OrderDetail(
    val dopings: List<Doping>,
    val menuProduct: MenuProductX,
    val order: String,
    val orderDetailId: Int,
    val price: Int,
    val quantity: Int
)