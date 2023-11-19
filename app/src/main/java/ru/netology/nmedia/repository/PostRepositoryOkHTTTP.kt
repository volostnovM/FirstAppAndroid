package ru.netology.nmedia.repository

import androidx.lifecycle.map
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import ru.netology.nmedia.api.PostsApi
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.dao.PostDao
import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Media
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.TypeAttachment
import ru.netology.nmedia.entity.PostEntity
import ru.netology.nmedia.entity.toDto
import ru.netology.nmedia.entity.toEntity
import ru.netology.nmedia.error.ApiException
import ru.netology.nmedia.error.NetworkException
import ru.netology.nmedia.error.UnknownException
import ru.netology.nmedia.model.PhotoModel
import java.io.File
import java.io.IOException

class PostRepositoryOkHTTTP(private val dao: PostDao) : PostRepository {

    companion object {
        private const val BASE_URL = "http://10.0.2.2:9999"
        private val jsonType = "application/json".toMediaType()
    }

    override val data = dao.getAll().map {
        it.toDto()
    }

    override suspend fun getAll() {
        try {
            val response = PostsApi.retrofitService.getAll()
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiException(response.code(), response.message())
            //dao.insert(body.toEntity())
            dao.insert(body.toEntity()
                .map {
                    it.copy(hidden = true)
                })
        } catch (e: ApiException) {
            throw e
        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }

    override fun getNewer(id: Long): Flow<Int> = flow {
        while (true) {
            delay(10_000L)

            try {
                val response = PostsApi.retrofitService.getNewer(id)
                if (!response.isSuccessful) {
                    throw ApiException(response.code(), response.message())
                }
                val body =
                    response.body() ?: throw ApiException(response.code(), response.message())
                dao.insert(body.toEntity())
                emit(body.size)
            } catch (e: ApiException) {
                throw e
            } catch (e: IOException) {
                throw NetworkException
            } catch (e: Exception) {
                throw UnknownException
            }
        }
    }

    override suspend fun getNewPosts() {
        try {
            dao.hiddenPosts()
        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }

    override suspend fun likeById(id: Long) {
        try {
            dao.likeById(id)
            val response = PostsApi.retrofitService.likeByIdAsync(id)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiException(response.code(), response.message())
        } catch (e: IOException) {
            dao.likeById(id)
            throw NetworkException
        } catch (e: Exception) {
            dao.likeById(id)
            throw UnknownException
        }
    }

    override suspend fun unlikeById(id: Long) {
        try {
            dao.likeById(id)
            val response = PostsApi.retrofitService.unlikeByIdAsync(id)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiException(response.code(), response.message())
        } catch (e: IOException) {
            dao.likeById(id)
            throw NetworkException
        } catch (e: Exception) {
            dao.likeById(id)
            throw UnknownException
        }
    }


    override suspend fun removeById(id: Long) {
        try {
            val response = PostsApi.retrofitService.removeByIdAsync(id)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            dao.removeById(id)
        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }

    override suspend fun save(post: Post) {
        try {
            val response = PostsApi.retrofitService.saveAsync(post)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiException(response.code(), response.message())
            dao.insert(PostEntity.fromDto(body))
        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }

    override suspend fun saveWithAttachment(post: Post, photoModel: PhotoModel) {
        try {
            val mediaResponse = saveMedia(photoModel.file)
            if (!mediaResponse.isSuccessful) {
                throw ApiException(mediaResponse.code(), mediaResponse.message())
            }

            val media = mediaResponse.body() ?: throw ApiException(mediaResponse.code(), mediaResponse.message())

            val response = PostsApi.retrofitService.saveAsync(post.copy(attachment = Attachment(media.id, TypeAttachment.IMAGE)))
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiException(response.code(), response.message())
            dao.insert(PostEntity.fromDto(body))
        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }

    private suspend fun saveMedia(file: File): Response<Media> {
        val part = MultipartBody.Part.createFormData("file", file.name, file.asRequestBody())
        return PostsApi.retrofitService.saveMedia(part)
    }

    override suspend fun signIn(login: String, pass: String) {
        try {
            val response = PostsApi.retrofitService.updateUser(login, pass)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val authState = response.body() ?: throw ApiException(response.code(), response.message())
            authState.token?.let { AppAuth.getInstance().setAuth(authState.id, it) }

        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
        return
    }

    override suspend fun signUp(name: String, login: String, pass: String) {
        try {
            val response = PostsApi.retrofitService.registerUser(login, pass, name)
            if (!response.isSuccessful) {
                throw ApiException(response.code(), response.message())
            }
            val authState = response.body() ?: throw ApiException(response.code(), response.message())
            authState.token?.let { AppAuth.getInstance().setAuth(authState.id, it) }

        } catch (e: IOException) {
            throw NetworkException
        } catch (e: Exception) {
            throw UnknownException
        }
    }
}