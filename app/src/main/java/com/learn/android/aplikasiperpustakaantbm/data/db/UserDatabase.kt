package com.learn.android.aplikasiperpustakaantbm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learn.android.aplikasiperpustakaantbm.data.model.BookEntity
import com.learn.android.aplikasiperpustakaantbm.data.model.PengunjungEntity
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import com.learn.android.aplikasiperpustakaantbm.domain.repository.UserRepository

@Database(
    entities = [UserEntity::class, BookEntity::class, PengunjungEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserRepository
}