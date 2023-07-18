package ru.netology.nmedia.service

object Service {
    fun numberCorrelation(number: Int): String {
        return when (number) {
            in 0..999 -> number.toString()
            in 1000..9999 -> (number.toDouble() / 1000.0).toString() + "K"
            in 10_000..999_999 -> (number / 1000).toString() + "K"
            else -> (number / 100_000).toString() + "M"
        }
    }
}