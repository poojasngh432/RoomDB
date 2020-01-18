package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertAllUser(users: List<User>)

    @Query("Select * From User")
    fun getAllUsers(): LiveData<List<User>>

    @Query("Select * From User where age > :elder")
    fun getAllUser(elder:Int):List<User>

    @Delete
    fun deleteUser(user: User)
}