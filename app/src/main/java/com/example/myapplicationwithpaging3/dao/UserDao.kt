package com.example.myapplicationwithpaging3.dao

import androidx.paging.PagingData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationwithpaging3.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postList: PagingData<UserEntity>)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getAllUser(): Flow<List<UserEntity>>
}