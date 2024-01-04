package nur.xan.neocafe.clientneocafe.data.api.controller.categoryContr

import nur.xan.neocafe.clientneocafe.models.allCategory.AllCategoryModels
import nur.xan.neocafe.clientneocafe.models.categoryMenuInfo.CategoryMenuListModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CategoryController {



    @GET("/api/client/menu/allCategory")
    suspend fun allCategory(
        @Header("Authorization") auth: String
    ): Response<AllCategoryModels>

    @GET("/api/client/menu/allCategory")
    suspend fun allCategoryInfo(
        @Header("Authorization") auth: String
    ): Response<AllCategoryModels>

    @GET("/api/client/menu/allMenuByCategory")
    suspend fun categoryMenuInfo(
        @Header("Authorization") auth: String,
        @Query("category_id") category_id: String
    ): Response<CategoryMenuListModels>




}