package com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel

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
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var inputUsername = MutableLiveData<String>()
    var inputPassword = MutableLiveData<String>()

    private var _loginEvent = MutableLiveData<Event<UserEntity>>()
    val loginEvent : LiveData<Event<UserEntity>> = _loginEvent


    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage


    fun login() {
        if (inputUsername.value == null && inputPassword.value == null) {
            statusMessage.value = Event("Please input your username and password")
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val username = userRepository.getUserData(inputUsername.value!!)
                if (username != null) {
                    withContext(Dispatchers.Main) {
                        if (username.password == inputPassword.value) {
                            inputUsername.value = ""
                            inputPassword.value = ""
                            statusMessage.value = Event("Anda Berhasil Login")
                            _loginEvent.value = Event(username)

                        } else {
                            statusMessage.value = Event("Password yang anda masukan tidak sesuai")
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        statusMessage.value = Event("Username yang anda masukan tidak ditemukan")

                    }
                }
            }
        }
    }
}