package com.example.myapplicationwithpaging3.entity

import androidx.paging.PagingData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplicationwithpaging3.model.UserDataModel

@Entity(tableName = "user")
data class UserEntity constructor(val body: UserDataModel) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}