package com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import com.learn.android.aplikasiperpustakaantbm.data.repository.BookRepository
import com.learn.android.aplikasiperpustakaantbm.data.repository.UserRepository
import com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment.HomeFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _user = MutableLiveData<Bitmap>()
    val userImage: LiveData<Bitmap>
        get() = _user


    fun getUser(userImage: Bitmap) {
        _user.postValue(userImage)
    }


}