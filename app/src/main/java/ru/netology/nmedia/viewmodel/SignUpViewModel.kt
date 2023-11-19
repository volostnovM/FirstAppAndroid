package ru.netology.nmedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.auth.AuthState
import ru.netology.nmedia.db.AppDb
import ru.netology.nmedia.model.FeedModelState
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryOkHTTTP

class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostRepository =
        PostRepositoryOkHTTTP(AppDb.getInstance(context = application).postDao)

    val data: LiveData<AuthState> = AppAuth.getInstance()
        .authState
        .asLiveData(Dispatchers.Default)

    private val _dataState = MutableLiveData<FeedModelState>()
    val dataState: LiveData<FeedModelState>
        get() = _dataState

    val authenticated: Boolean
        get() = AppAuth.getInstance().authState.value.id != 0L

    fun signeUp(name: String, login: String, pass: String) {
        viewModelScope.launch {
            try {
                _dataState.value = FeedModelState(loading = true)
                repository.signUp(name, login, pass)
                _dataState.value = FeedModelState(loading = false, error = false, authState = true)
            } catch (e : Exception) {
                _dataState.value = FeedModelState(loading = false, error = true, authState = false)
            }
        }
    }

}