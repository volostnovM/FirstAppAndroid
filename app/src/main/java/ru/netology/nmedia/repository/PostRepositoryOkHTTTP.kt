package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import ru.netology.nmedia.dto.Post
import java.util.concurrent.TimeUnit

class PostRepositoryOkHTTTP: PostRepository {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
    private val gson = Gson()
    private val typeToken = object : TypeToken<List<Post>>() {}

    companion object {
        private const val BASE_URL = "http://10.0.2.2:9999"
        private val jsonType = "application/json".toMediaType()
    }
    override fun get(): List<Post> {
        val request: Request = Request.Builder()
            .url("${BASE_URL}/api/slow/posts")
            .build()

        return client.newCall(request)
            .execute()
            .let { it.body?.string() ?: throw RuntimeException("body is null") }
            .let {
                gson.fromJson(it, typeToken.type)
            }
    }

    override fun likeById(id: Long): Post {
        val request: Request = Request.Builder()
            .post(gson.toJson(Unit).toRequestBody(jsonType))
            .url("${BASE_URL}/api/posts/$id/likes")
            .build()

        val call = client.newCall(request)
        val response = call.execute()
        val responseString = response.body?.string() ?: error("Body with likes is null")
        return gson.fromJson(responseString, Post::class.java)
    }

    override fun unlikeById(id: Long): Post {
        val request: Request = Request.Builder()
            .delete(gson.toJson(Unit).toRequestBody(jsonType))
            .url("${BASE_URL}/api/posts/$id/likes")
            .build()

        val call = client.newCall(request)
        val response = call.execute()
        val responseString = response.body?.string() ?: error("Body with likes is null")
        return gson.fromJson(responseString, Post::class.java)
    }

    override fun share(id: Long) {
        println("Not yet implemented")
    }

    override fun removeById(id: Long) {
        val request: Request = Request.Builder()
            .delete()
            .url("${BASE_URL}/api/slow/posts/$id")
            .build()

        client.newCall(request)
            .execute()
            .close()
    }

    override fun save(post: Post): Post {
        val request: Request = Request.Builder()
            .post(gson.toJson(post).toRequestBody(jsonType))
            .url("${BASE_URL}/api/slow/posts")
            .build()

        val call = client.newCall(request)
        val response = call.execute()
        val responseString = response.body?.string() ?: error("Body is null")
        return gson.fromJson(responseString, Post::class.java)
    }
}