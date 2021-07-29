package com.example.myapplicationwithpaging3.repository

import androidx.annotation.WorkerThread
import androidx.paging.PagingData
import com.example.myapplicationwithpaging3.dao.UserDao
import com.example.myapplicationwithpaging3.entity.UserEntity
import com.example.myapplicationwithpaging3.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val apiService: ApiService
) {

    val getAllUser: Flow<List<UserEntity>> = userDao.getAllUser()

    @WorkerThread
    suspend fun insert(postList: PagingData<UserEntity>) = withContext(Dispatchers.IO) {
        userDao.insert(postList)
    }

}