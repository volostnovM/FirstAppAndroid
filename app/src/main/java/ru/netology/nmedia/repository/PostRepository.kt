package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun get(): List<Post>
    fun likeById(id: Long): Post
    fun unlikeById(id: Long): Post
    fun share(id: Long)
    fun removeById(id: Long)
    fun save(post: Post): Post
}