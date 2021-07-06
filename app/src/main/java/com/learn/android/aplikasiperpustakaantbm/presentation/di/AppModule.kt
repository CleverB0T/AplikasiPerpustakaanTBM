package com.learn.android.aplikasiperpustakaantbm.presentation.di

import android.content.Context
import androidx.room.Room
import com.learn.android.aplikasiperpustakaantbm.data.db.DatabaseTBM
import com.learn.android.aplikasiperpustakaantbm.data.other.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        DatabaseTBM::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideBookDao(db: DatabaseTBM) = db.bookDao()

    @Singleton
    @Provides
    fun provideUserDao(db: DatabaseTBM) = db.userDao()

    @Singleton
    @Provides
    fun providePengunjungDao(db: DatabaseTBM) = db.pengunjungDao()


}