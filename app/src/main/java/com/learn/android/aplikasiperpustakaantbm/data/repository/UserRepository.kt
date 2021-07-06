package com.learn.android.aplikasiperpustakaantbm.data.repository

import com.learn.android.aplikasiperpustakaantbm.data.dao.UserDao
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UserRepository @Inject constructor(
    val userDao: UserDao
) {

    suspend fun insert(userEntity: UserEntity) = userDao.insertUser(userEntity)

    suspend fun getUserData(username: String) : UserEntity = userDao.getDataUser(username)


    fun getAllUser() = userDao.getAllUser()

    fun getTotalUser() = userDao.getTotalUser()
}