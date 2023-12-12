package ru.netology.nmedia.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.auth.AuthState
import ru.netology.nmedia.model.FeedModelState
import ru.netology.nmedia.repository.PostRepository
import javax.inject.Inject
@HiltViewModel
class SignInViewModel @Inject constructor (
    private val repository: PostRepository,
    private val appAuth: AppAuth
) : ViewModel() {


    val data: LiveData<AuthState> = appAuth
        .authState
        .asLiveData(Dispatchers.Default)

    private val _dataState = MutableLiveData<FeedModelState>()
    val dataState: LiveData<FeedModelState>
        get() = _dataState

    val authenticated: Boolean
        get() = appAuth.authState.value.id != 0L

    fun signIn(login: String, pass: String) {
        viewModelScope.launch {
            try {
                _dataState.value = FeedModelState(loading = true)
                repository.signIn(login, pass)
                _dataState.value = FeedModelState(loading = false, error = false, authState = true)
            } catch (e: Exception) {
                _dataState.value = FeedModelState(loading = false, error = true, authState = false)
            }
        }
    }
}