package ru.netology.nmedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.netology.nmedia.db.AppDb
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.model.FeedModel
import ru.netology.nmedia.model.FeedModelState
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryOkHTTTP
import ru.netology.nmedia.util.SingleLiveEvent
import java.io.IOException
import kotlin.concurrent.thread

private val empty = Post(
    id = 0,
    published = "",
    author = "",
    authorAvatar = "",
    content = "",
    likedByMe = false,
    likes = 0,
    attachment = null
)

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PostRepository =
        PostRepositoryOkHTTTP(AppDb.getInstance(application).postDao)
    private val _postCreated = SingleLiveEvent<Unit>()
    val postCreated: LiveData<Unit>
        get() = _postCreated

    val data: LiveData<FeedModel> = repository.data.map {
        FeedModel(posts = it, empty = it.isEmpty())
    }

    private val edited = MutableLiveData(empty)

    private val _dataState = MutableLiveData<FeedModelState>()
    val state: LiveData<FeedModelState> get() = _dataState

    init {
        loadPosts()
    }

    fun loadPosts() = viewModelScope.launch {
        try {
            _dataState.value = FeedModelState(loading = true)
            repository.getAll()
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun refreshPosts() = viewModelScope.launch {
        try {
            _dataState.value = FeedModelState(refreshing = true)
            repository.getAll()
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun changeContentAndSave(content: String) {
        edited.value?.let {
            val text = content.trim()
            if (it.content != content) {
                _postCreated.value = Unit
                viewModelScope.launch {
                    try {
                        it.copy(content = text)
                        println("search ${it.toString()}")
                        repository.save(it)
                        _dataState.value = FeedModelState()
                    } catch (e: Exception) {
                        _dataState.value = FeedModelState(error = true)
                    }
                }
            }
        }
    }

    fun edit(post: Post) {
        edited.value = post
    }

    fun cancelEditing() {
        edited.value = empty
    }

    fun likeById(id: Long) = viewModelScope.launch {
        try {
            repository.likeById(id)
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun unlikeById(id: Long) = viewModelScope.launch {
        try {
            repository.unlikeById(id)
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun removeById(id: Long) = viewModelScope.launch {
        try {
            repository.removeById(id)
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }
}
