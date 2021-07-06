package com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.android.aplikasiperpustakaantbm.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    val bookRepository: BookRepository
) : ViewModel() {


}