package com.example.roomdb

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

    @Query("SELECT * FROM User WHERE age > :elder")
    fun getAllUsers(elder: Int): List<User>

    @Delete
    fun deleteUser(user: User)
}