package nur.xan.neocafe.clientneocafe.viewModels.categoryVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.launch
import nur.xan.neocafe.clientneocafe.models.allCategory.AllCategoryModels
import nur.xan.neocafe.clientneocafe.models.categoryMenuInfo.CategoryMenuListModels
import nur.xan.neocafe.clientneocafe.repository.category.CategoryRepository
import retrofit2.Response

class CategoryVM : ViewModel() {
    private val repo = CategoryRepository()


    val myAllCategory: MutableLiveData<Response<CategoryMenuListModels>> = MutableLiveData()
    val myAllCategoryInfo: MutableLiveData<Response<AllCategoryModels>> = MutableLiveData()


    fun categoryMenuInfo(auth: String,category_id: String) {
        viewModelScope.launch {
            myAllCategory.value = repo.categoryMenuInfoRepository(auth, category_id)
        }
    }

    fun allCategoryInfo(auth: String) {
        viewModelScope.launch {
            myAllCategoryInfo.value = repo.allCategoryInfoRepository(auth)
        }
    }

    fun getCategoryPagingLiveData() = repo.getCategoryPagingRepository().cachedIn(viewModelScope)
}