package nur.xan.neocafe.clientneocafe.repository.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import nur.xan.neocafe.clientneocafe.data.api.retrofit.RetroFitInstance
import nur.xan.neocafe.clientneocafe.models.allCategory.AllCategoryModels
import nur.xan.neocafe.clientneocafe.models.categoryMenuInfo.CategoryMenuListModels
import nur.xan.neocafe.clientneocafe.models.search.SearchModels
import nur.xan.neocafe.clientneocafe.uiClient.home.adapter.CategorySource
import retrofit2.Response

class SearchRepository {


    suspend fun searchRepository( auth: String, name: String): Response<SearchModels> {
        return RetroFitInstance.allController.search(auth, name)
    }


}