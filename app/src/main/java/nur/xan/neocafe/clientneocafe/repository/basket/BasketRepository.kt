package nur.xan.neocafe.clientneocafe.repository.category

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import nur.xan.neocafe.clientneocafe.data.api.retrofit.RetroFitInstance
import nur.xan.neocafe.clientneocafe.models.allCategory.AllCategoryModels
import nur.xan.neocafe.clientneocafe.models.categoryMenuInfo.CategoryMenuListModels
import nur.xan.neocafe.clientneocafe.uiClient.home.adapter.CategorySource
import retrofit2.Response

class CategoryRepository {


    suspend fun categoryMenuInfoRepository( auth: String, category_id: String): Response<CategoryMenuListModels> {
        return RetroFitInstance.categoryController.categoryMenuInfo(auth, category_id)
    }

    suspend fun allCategoryInfoRepository( auth: String): Response<AllCategoryModels> {
        return RetroFitInstance.categoryController.allCategoryInfo(auth)
    }

    fun getCategoryPagingRepository(
    ) = Pager(
        config = PagingConfig(
            pageSize = 3,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { CategorySource(RetroFitInstance.categoryController) }
    ).liveData



}