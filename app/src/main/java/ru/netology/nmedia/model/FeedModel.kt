package ru.netology.nmedia.model

import ru.netology.nmedia.dto.Post

data class FeedModel (
    val posts: List<Post> = emptyList(),
    val empty: Boolean = false,
)

data class FeedModelState(
    val loading: Boolean = false,
    val refreshing: Boolean = false,
    val errorMessage: String = "",
    val errorLike: Boolean = false,
    val error: Boolean = false,
    val serverError: Boolean = false,
    val authState: Boolean = false
)