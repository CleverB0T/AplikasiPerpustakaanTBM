package com.learn.android.aplikasiperpustakaantbm.domain.repository

import androidx.room.*
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity

@Dao
interface UserRepository {

    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM users_table")
    fun getAllUser(): List<UserEntity>

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)
}