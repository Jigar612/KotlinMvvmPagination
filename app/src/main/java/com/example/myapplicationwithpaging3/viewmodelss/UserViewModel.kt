package com.example.myapplicationwithpaging3.viewmodelss

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.myapplicationwithpaging3.entity.UserEntity
import com.example.myapplicationwithpaging3.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserViewModel
@ViewModelInject
constructor(private val userRepository: UserRepository) : ViewModel() {

    val getAllUserData: LiveData<List<UserEntity>>
        get() = userRepository.getAllUser
            .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)

    fun insert(postList: PagingData<UserEntity>) = viewModelScope.launch {
        userRepository.insert(postList)
    }

    /*val getData = userRepository.getAllUser()
        .catch { e ->
            Log.d("main", "${e.message}")
        }.asLiveData()*/

}