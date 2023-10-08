package ru.netology.nmedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.model.FeedModel
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryOkHTTTP
import ru.netology.nmedia.util.SingleLiveEvent
import java.io.IOException
import kotlin.concurrent.thread

private val empty = Post(
    id = 0,
    published = "",
    author = "",
    content = "",
    likedByMe = false,
    likes = 0,
    shared = 0
)

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PostRepository = PostRepositoryOkHTTTP()
    private val _postCreated = SingleLiveEvent<Unit>()
    val postCreated: LiveData<Unit> = _postCreated

    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel> = _data
    private val edited = MutableLiveData(empty)

    init {
        loadPosts()
    }

    fun loadPosts() {
        thread {
            // Начинаем загрузку
            _data.postValue(FeedModel(loading = true, refreshing = true))
            try {
                // Данные успешно получены
                val posts = repository.get()
                FeedModel(posts = posts, empty = posts.isEmpty())
            } catch (e: IOException) {
                // Получена ошибка
                FeedModel(error = true)
            }.also(_data::postValue)
        }
    }

    fun changeContentAndSave(content: String) {
        thread {
            edited.value?.let {
                val text = content.trim()
                if (it.content != content) {
                    repository.save(it.copy(content = text))
                    loadPosts()
                }
            }
            _postCreated.postValue(Unit)
            edited.postValue(empty)
        }
    }

    fun edit(post: Post) {
        edited.value = post
    }

    fun cancelEditing() {
        edited.value = empty
    }

    fun likeById(id: Long) {
        thread { repository.likeById(id) }
    }

    fun unlikeById(id: Long) {
        thread { repository.unlikeById(id) }
    }

    fun share(id: Long) = repository.share(id)
    fun removeById(id: Long) {
        thread {
            val old = _data.value

            try {
                repository.removeById(id)

                _data.postValue(
                    old?.copy(
                        posts = old.posts.filter {
                            it.id != id
                        }
                    )
                )
            } catch (e: Exception) {
                _data.postValue(old)
            }
        }
    }
}