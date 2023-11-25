package ru.netology.nmedia.error

import ru.netology.nmedia.R

sealed class AppError(private val code: Int, private val info: String) : RuntimeException()
class ApiException(code: Int, info: String) : AppError(code, info)
object NetworkException : AppError(code = -1, info = "No_Network_Exception")
object UnknownException : AppError(code = -2, info = "Unknown_Exception")

object SignInException: AppError(-3, (R.string.sign_in_exception_message).toString())
object SignUpException: AppError(-4, (R.string.sign_up_exception_message).toString())