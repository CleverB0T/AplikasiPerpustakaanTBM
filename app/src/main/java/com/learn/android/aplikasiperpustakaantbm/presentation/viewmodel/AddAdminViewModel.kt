package com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import com.learn.android.aplikasiperpustakaantbm.data.repository.UserRepository
import com.learn.android.aplikasiperpustakaantbm.data.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddAdminViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var nameAdmin = MutableLiveData<String>()
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var imageAdmin = MutableLiveData<Bitmap>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage


    fun saveDataAdmin() {
        if (nameAdmin.value == null) {
            statusMessage.value = Event("Please input name admin")
        } else if (username == null) {
            statusMessage.value = Event("Please input username")
        } else if (password == null) {
            statusMessage.value = Event("Please input password")
        } else {

            val name = nameAdmin.value
            val user = username.value
            val pass = password.value
            val image = imageAdmin.value

            insertUser(UserEntity(name, user, pass, image))

            nameAdmin.value = ""
            username.value = ""
            password.value = ""
            statusMessage.value = Event("Data Admin Telah ditambahkan")
        }
    }


    private fun insertUser(userEntity: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.insert(userEntity)
    }

}