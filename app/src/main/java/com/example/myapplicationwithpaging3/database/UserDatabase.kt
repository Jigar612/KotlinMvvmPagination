package com.example.myapplicationwithpaging3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationwithpaging3.dao.UserDao
import com.example.myapplicationwithpaging3.model.UserDataModel

@Database(entities = [UserDataModel::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getPostDao(): UserDao
}