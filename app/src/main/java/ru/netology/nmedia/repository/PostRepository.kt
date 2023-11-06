package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
//    fun getAllAsync(callback: RepositoryCallback<List<Post>>)
//    fun likeByIdAsync(id: Long, callback: RepositoryCallback<Post>)
//    fun unlikeByIdAsync(id: Long, callback: RepositoryCallback<Post>)
//    fun removeByIdAsync(id: Long, callback: RepositoryCallback<Unit>)
//    fun saveAsync(post: Post, callback: RepositoryCallback<Post>)
//    fun share(id: Long)
//
//    interface RepositoryCallback<T> {
//        fun onSuccess(result: T)
//        fun onError(e: Exception)
//    }

    val data: LiveData<List<Post>>
    suspend fun getAll()
    suspend fun likeById(id: Long)
    suspend fun unlikeById(id: Long)
    suspend fun removeById(id: Long)
    suspend fun save(post: Post)
}