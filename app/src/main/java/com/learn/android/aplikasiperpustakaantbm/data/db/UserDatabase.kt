package com.learn.android.aplikasiperpustakaantbm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learn.android.aplikasiperpustakaantbm.data.model.BookEntity
import com.learn.android.aplikasiperpustakaantbm.data.model.PengunjungEntity
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import com.learn.android.aplikasiperpustakaantbm.data.utils.TypeConverterDate
import com.learn.android.aplikasiperpustakaantbm.data.utils.TypeConverterImage
import com.learn.android.aplikasiperpustakaantbm.domain.repository.UserRepository

@Database(
    entities = [UserEntity::class, BookEntity::class, PengunjungEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverterDate::class, TypeConverterImage::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserRepository
}