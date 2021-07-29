package com.example.myapplicationwithpaging3.viewmodelss

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.myapplicationwithpaging3.data.pagingsource.UserPagingSource
import com.example.myapplicationwithpaging3.model.UserDataModel
import com.example.myapplicationwithpaging3.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val apiService: ApiService) : ViewModel() {

    fun getAllUserList(): Flow<PagingData<UserDataModel>> = Pager(
        config = PagingConfig(pageSize = 4, enablePlaceholders = false)
    ) {
        UserPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}