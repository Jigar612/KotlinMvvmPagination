package com.example.myapplicationwithpaging3.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplicationwithpaging3.model.UserDataModel
import com.example.myapplicationwithpaging3.retrofit.ApiService
import retrofit2.HttpException
import java.io.IOException

class UserPagingSource constructor(private val apiService: ApiService) :
    PagingSource<Int, UserDataModel>() {
    override fun getRefreshKey(state: PagingState<Int, UserDataModel>): Int? {
        return null


    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserDataModel> {

        val page = params.key ?: 1
        return try {
            val response = apiService.getList(page, params.loadSize)
            LoadResult.Page(
                response.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }
}