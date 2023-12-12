package ru.netology.nmedia.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.netology.nmedia.api.PostsApiService
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.error.ApiException

class PostPagingSourse (
    private val service: PostsApiService,
    ) : PagingSource<Long, Post>() {
        override fun getRefreshKey(state: PagingState<Long, Post>): Long? = null

        override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Post> {
            try {
                val response = when (params) {
                    is LoadParams.Refresh -> service.getLatest(params.loadSize)
                    is LoadParams.Prepend -> return LoadResult.Page(
                        data = emptyList(),
                        prevKey = params.key,
                        nextKey = null
                    )

                    is LoadParams.Append -> service.getBefore(params.key, params.loadSize)
                }

                if (!response.isSuccessful) {
                    throw ApiException(response.code(), response.message())
                }

                val data = response.body().orEmpty()
                return LoadResult.Page(
                    data = data,
                    prevKey = params.key,
                    nextKey = data.lastOrNull()?.id
                )
            } catch (e: Exception) {
                return LoadResult.Error(e)
            }
        }
    }