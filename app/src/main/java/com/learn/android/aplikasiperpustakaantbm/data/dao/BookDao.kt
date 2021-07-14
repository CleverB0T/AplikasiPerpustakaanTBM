package com.learn.android.aplikasiperpustakaantbm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learn.android.aplikasiperpustakaantbm.data.model.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert
    suspend fun insert(bookEntity: BookEntity)

    @Query("SELECT * FROM books_table")
    fun getAllBooks(): LiveData<List<BookEntity>>

    @Query("SELECT * FROM books_table ORDER BY timestamp DESC")
    fun getAllBookSortedByDate(): LiveData<List<BookEntity>>

    @Query("SELECT * FROM books_table ORDER BY kategory DESC")
    fun getAllBookSortedByKategory(): LiveData<List<BookEntity>>

    @Query("SELECT * FROM books_table ORDER BY genre DESC")
    fun getAllBookSortedByGenre(): LiveData<List<BookEntity>>

    @Query("SELECT * FROM books_table ORDER BY favorite DESC")
    fun getAllBookSortedByFavorite(): LiveData<List<BookEntity>>

    @Query("SELECT SUM(jumlahBuku) FROM books_table")
    fun getTotalBooks(): LiveData<Int>
}