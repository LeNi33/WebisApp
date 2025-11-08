package com.example.webisapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.webisapp.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUser(email: String, password: String): User?

    @Insert
    suspend fun insertUser(user: User)
}

