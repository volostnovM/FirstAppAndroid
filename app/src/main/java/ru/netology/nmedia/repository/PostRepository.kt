package ru.netology.nmedia.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.model.PhotoModel

interface PostRepository {
    val data: Flow<List<Post>>
    suspend fun getAll()
    suspend fun getNewPosts()

    fun getNewer(id: Long): Flow<Int>
    suspend fun likeById(id: Long)
    suspend fun unlikeById(id: Long)
    suspend fun removeById(id: Long)
    suspend fun save(post: Post)
    suspend fun saveWithAttachment(post: Post, photoModel: PhotoModel)

    suspend fun signIn(login: String, pass: String)

    suspend fun signUp(name: String, login: String, pass: String)
}