package ru.netology.nmedia.repository

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.netology.nmedia.dto.Post

class PostRepositoryFromFiles(private val context: Context) : PostRepository {

    private var posts = emptyList<Post>()
    private var nextId = 1L
    private val gson = Gson()
    private val data = MutableLiveData(posts)
    private val postsFileName = "posts.json"
    private val nextIdFileName = "nextId.json"
    private val type = TypeToken.getParameterized(List::class.java, Post::class.java).type

    init {
        val postFile = context.filesDir.resolve(postsFileName)
        posts = if (postFile.exists()) {
            postFile.reader().buffered().use {
                gson.fromJson(it, type)
            }
        } else {
            emptyList()
        }

        val idFile = context.filesDir.resolve(nextIdFileName)
        nextId = if (idFile.exists()) {
            idFile.reader().buffered().use {
                gson.fromJson(it, Long::class.java)
            }
        } else {
            nextId
        }

        data.value = posts
    }
    override fun get(): LiveData<List<Post>> = data

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                likedByMe = !it.likedByMe,
                likes = if (it.likedByMe) it.likes - 1 else it.likes + 1
            )
        }
        data.value = posts
        sync()
    }

    override fun share(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(shared = it.shared + 1)
        }
        data.value = posts
        sync()
    }

    override fun removeById(id: Long) {
        posts = posts.filter {
            it.id != id
        }
        data.value = posts
        sync()
    }

    override fun save(post: Post) {
        posts = if (post.id == 0L) {
            listOf(post.copy(id = nextId++, author = "Me", published = "now")) + posts
        } else {
            posts.map {
                if (it.id != post.id) it else it.copy(content = post.content)
            }
        }
        data.value = posts
        sync()
    }

    private fun sync() {
        context.filesDir.resolve(postsFileName).writer().buffered().use {
            it.write(gson.toJson(posts))
        }

        context.filesDir.resolve(nextIdFileName).writer().buffered().use {
            it.write(gson.toJson(nextId))
        }
    }
}