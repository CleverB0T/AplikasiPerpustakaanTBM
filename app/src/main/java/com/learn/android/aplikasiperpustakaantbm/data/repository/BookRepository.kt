package com.learn.android.aplikasiperpustakaantbm.data.repository

import com.learn.android.aplikasiperpustakaantbm.data.dao.BookDao
import com.learn.android.aplikasiperpustakaantbm.data.model.BookEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class BookRepository @Inject constructor(
    val bookDao: BookDao
) {

    suspend fun insertBook(bookEntity: BookEntity) = bookDao.insert(bookEntity)

    fun getAllBooks() = bookDao.getAllBooks()

    fun getAllBookSortedByDate() = bookDao.getAllBookSortedByDate()

    fun getAllBookSortedByCategory() = bookDao.getAllBookSortedByKategory()

    fun getAllBookSortedByGenre() = bookDao.getAllBookSortedByGenre()

    fun getAllBookSortedByFavorite() = bookDao.getAllBookSortedByFavorite()

    fun getTotalBooks() = bookDao.getTotalBooks()


}