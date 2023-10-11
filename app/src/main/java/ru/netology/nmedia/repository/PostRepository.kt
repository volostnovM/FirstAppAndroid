package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun getAllAsync(callback: RepositoryCallback<List<Post>>)
    fun likeByIdAsync(id: Long, callback: RepositoryCallback<Post>)
    fun unlikeByIdAsync(id: Long, callback: RepositoryCallback<Post>)
    fun share(id: Long)
    fun removeByIdAsync(id: Long, callback: RepositoryCallback<Unit>)
    fun save(post: Post): Post
    fun saveAsync(post: Post, callback: RepositoryCallback<Post>)

    interface RepositoryCallback<T> {
        fun onSuccess(result: T)
        fun onError(e: Exception)
    }
}