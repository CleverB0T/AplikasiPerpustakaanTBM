package com.learn.android.aplikasiperpustakaantbm.data.dao

import androidx.room.*
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM users_table")
    fun getAllUser(): Flow<List<UserEntity>>

    @Query("SELECT * FROM users_table where username LIKE :username")
    suspend fun getDataUser(username: String): UserEntity

    @Query("SELECT SUM(id) FROM users_table")
    fun getTotalUser(): Flow<Int>

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)
}