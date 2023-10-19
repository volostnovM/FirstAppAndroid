package ru.netology.nmedia.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.netology.nmedia.api.PostsApi
import ru.netology.nmedia.dto.Post
import java.io.IOException
import java.util.concurrent.TimeUnit

class PostRepositoryOkHTTTP : PostRepository {

    companion object {
        private const val BASE_URL = "http://10.0.2.2:9999"
        private val jsonType = "application/json".toMediaType()
    }

    override fun getAllAsync(callback: PostRepository.RepositoryCallback<List<Post>>) {
        PostsApi.retrofitService.getAll()
            .enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() ?: throw RuntimeException("empty body"))
                    } else {
                        callback.onError(RuntimeException("error code ${response.code()} with ${response.message()}"))
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    callback.onError(Exception(t))
                }
            })
    }

    override fun likeByIdAsync(id: Long, callback: PostRepository.RepositoryCallback<Post>) {
        PostsApi.retrofitService.likeByIdAsync(id)
            .enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() ?: throw RuntimeException("empty body"))
                    } else {
                        callback.onError(RuntimeException("error code ${response.code()} with ${response.message()}"))
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    callback.onError(Exception(t))
                }
            })
    }

    override fun unlikeByIdAsync(
        id: Long,
        callback: PostRepository.RepositoryCallback<Post>
    ) {
        PostsApi.retrofitService.unlikeByIdAsync(id)
            .enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() ?: throw RuntimeException("empty body"))
                    } else {
                        callback.onError(RuntimeException("error code ${response.code()} with ${response.message()}"))
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    callback.onError(Exception(t))
                }
            })
    }

    override fun share(id: Long) {
        println("Not yet implemented")
    }

    override fun removeByIdAsync(
        id: Long,
        callback: PostRepository.RepositoryCallback<Unit>
    ) {
        PostsApi.retrofitService.removeByIdAsync(id)
            .enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    callback.onSuccess(Unit)
                }


                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    callback.onError(Exception(t))
                }
            })
    }

    override fun saveAsync(post: Post, callback: PostRepository.RepositoryCallback<Post>) {
        PostsApi.retrofitService.saveAsync(post)
            .enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() ?: throw RuntimeException("Error save"))
                    } else {
                        callback.onError(RuntimeException("error code ${response.code()} with ${response.message()}"))
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    callback.onError(Exception(t))
                }
            })
    }
}