package ru.netology.nmedia.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.model.FeedModel
import ru.netology.nmedia.model.FeedModelState
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.util.SingleLiveEvent
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.paging.PagingData
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.switchMap
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.model.PhotoModel
import java.io.File
import javax.inject.Inject


private val empty = Post(
    id = 0,
    published = "",
    author = "",
    authorAvatar = "",
    content = "",
    likedByMe = false,
    likes = 0,
    attachment = null,
    authorId = 0
)
@HiltViewModel
class PostViewModel @Inject constructor (
    private val repository: PostRepository,
    appAuth: AppAuth
) : ViewModel() {

    private val _postCreated = SingleLiveEvent<Unit>()
    val postCreated: LiveData<Unit>
        get() = _postCreated

    @OptIn(ExperimentalCoroutinesApi::class)
    val data: Flow<PagingData<Post>> = appAuth
        .authState
        .flatMapLatest {auth ->
            repository.data
                .map {postsMap ->
                    postsMap.map {it.copy(ownedByMe = auth.id == it.authorId)}
                }
                .catch { it.printStackTrace() }
        }
        .flowOn(Dispatchers.Default)

    private val _photo = MutableLiveData<PhotoModel?>(null)
    val photo: LiveData<PhotoModel?> get() = _photo

    private val edited = MutableLiveData(empty)

    private val _dataState = MutableLiveData<FeedModelState>()
    val state: LiveData<FeedModelState> get() = _dataState

    init {
        loadPosts()
    }

    fun loadPosts() = viewModelScope.launch {
        try {
            _dataState.value = FeedModelState(loading = true)
//            repository.getAll()
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun setPhoto(uri: Uri, file: File) {
        _photo.value = PhotoModel(uri, file)
    }

    fun removePhoto() {
        edited.value = edited.value?.copy(attachment = null)
    }

//    fun loadNewPosts() = viewModelScope.launch {
//        try {
//            _dataState.value = FeedModelState(loading = true)
//            repository.getNewPosts()
//            _dataState.value = FeedModelState()
//        } catch (e: Exception) {
//            _dataState.value = FeedModelState(error = true)
//        }
//    }

//    fun refreshPosts() = viewModelScope.launch {
//        try {
//            _dataState.value = FeedModelState(refreshing = true)
//            repository.getAll()
//            _dataState.value = FeedModelState()
//        } catch (e: Exception) {
//            _dataState.value = FeedModelState(error = true)
//        }
//    }

    fun changeContentAndSave(content: String) {
        edited.value?.let {
            val text = content.trim()
            if (it.content != content) {

                viewModelScope.launch {
                    try {
                        val photoModel = _photo.value
                        if (photoModel == null) {
                            repository.save(it.copy(content = text))
                        } else {
                            repository.saveWithAttachment(it.copy(content = text), photoModel)
                        }

                        _dataState.value = FeedModelState()
                        _postCreated.value = Unit
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

    fun clearPhoto() {
        _photo.value = null
    }
}
