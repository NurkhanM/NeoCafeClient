package nur.xan.neocafe.clientneocafe.viewModels.searchVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nur.xan.neocafe.clientneocafe.models.search.SearchModels
import nur.xan.neocafe.clientneocafe.repository.search.SearchRepository
import retrofit2.Response

class SearchVM : ViewModel() {
    private val repo = SearchRepository()

    val mySearch: MutableLiveData<Response<SearchModels>> = MutableLiveData()

    fun search(auth: String, name: String) {
        viewModelScope.launch {
            mySearch.value = repo.searchRepository(auth, name)
        }
    }


}