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
        _data.postValue(FeedModel(loading = true, refreshing = true))
        repository.getAllAsync(object : PostRepository.RepositoryCallback<List<Post>> {
            override fun onSuccess(result: List<Post>) {
                _data.postValue(FeedModel(posts = result, empty = result.isEmpty()))
            }

            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))
            }
        })
    }

    fun changeContentAndSave(content: String) {
        edited.value?.let {
            val text = content.trim()
            if (it.content != content) {
                repository.saveAsync(
                    it.copy(content = text),
                    object : PostRepository.RepositoryCallback<Post> {
                        override fun onSuccess(result: Post) {
                            loadPosts()
                            _postCreated.postValue(Unit)
                            edited.postValue(empty)
                        }

                        override fun onError(e: Exception) {
                            edited.postValue(empty)
                        }
                    })
            }
        }
    }

    fun edit(post: Post) {
        edited.value = post
    }

    fun cancelEditing() {
        edited.value = empty
    }

    fun likeByIdAsync(id: Long) {
        repository.likeByIdAsync(id = id, object : PostRepository.RepositoryCallback<Post> {
            override fun onSuccess(result: Post) {
                val value = _data.value

                val updatesPosts = value?.posts?.map {
                    if (it.id == id) {
                        result
                    } else {
                        it
                    }
                }.orEmpty()

                _data.postValue(
                    value?.copy(posts = updatesPosts)
                )
            }

            override fun onError(e: Exception) {
                println("Упс, произошла ошибка во время простановки лайка")
            }
        })
    }

    fun unlikeByIdAsync(id: Long) {
        repository.unlikeByIdAsync(id = id, object : PostRepository.RepositoryCallback<Post> {
            override fun onSuccess(result: Post) {
                val value = _data.value

                val updatesPosts = value?.posts?.map {
                    if (it.id == id) {
                        result
                    } else {
                        it
                    }
                }.orEmpty()

                _data.postValue(
                    value?.copy(posts = updatesPosts)
                )
            }

            override fun onError(e: Exception) {
                println("Упс, произошла ошибка во время простановки лайка")
            }
        })
    }

    fun share(id: Long) = repository.share(id)
    fun removeByIdAsync(id: Long) {
        repository.removeByIdAsync(id = id, object : PostRepository.RepositoryCallback<Unit> {
            override fun onSuccess(result: Unit) {
                val old = _data.value

                try {
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

            override fun onError(e: Exception) {
                println("Упс, произошла ошибка во время удаления поста")
            }
        })
    }
}