package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val authorAvatar: String,
    val authorId: Long,
    val published: String,
    val content: String,
    val likedByMe: Boolean = false,
    val likes: Int,
    val hidden: Boolean = false,
    val attachment: Attachment? = null,
    val ownedByMe: Boolean = false
)

data class Attachment(
    val url: String,
    val type: TypeAttachment = TypeAttachment.IMAGE
)

enum class TypeAttachment {
    IMAGE
}