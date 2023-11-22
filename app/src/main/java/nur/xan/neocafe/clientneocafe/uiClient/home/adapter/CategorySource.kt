package nur.xan.neocafe.clientneocafe.uiClient.home.category

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import nur.xan.neocafe.clientneocafe.data.api.controller.categoryContr.CategoryController
import nur.xan.neocafe.clientneocafe.models.test.TestCategory
import java.io.IOException

class CategorySource
    (
    private val apiService: CategoryController,
) : PagingSource<Int, TestCategory>() {

    override fun getRefreshKey(state: PagingState<Int, TestCategory>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, TestCategory> {
        val currentPage = params.key ?: 1

        return try {
//            val response = apiService.allCategory(currentPage)
//            val data = response.body()?.data?.get(0)?.children ?: emptyList()
            val responseData = mutableListOf<TestCategory>()

            responseData.add(TestCategory(1, "Кофе"))
            responseData.add(TestCategory(2, "Десерты"))
            responseData.add(TestCategory(3, "Коктейли"))
            responseData.add(TestCategory(4, "Выпечка"))
            responseData.add(TestCategory(5, "Чай"))

            responseData.addAll(responseData)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (responseData.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


}