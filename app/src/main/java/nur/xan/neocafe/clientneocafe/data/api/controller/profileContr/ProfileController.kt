package nur.xan.neocafe.clientneocafe.data.api.controller.menuContr

import nur.xan.neocafe.clientneocafe.models.menu.MenuModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MenuController {

    @GET("/api/client/menu/allMenuProducts")
    suspend fun allMenuProducts(
        @Header("Authorization") auth: String
    ): Response<MenuModels>
}