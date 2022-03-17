package dev.empwr.usain.shortener.utils

object UrlShortener {
    private const val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    private const val BASE = ALPHABET.length
    fun encode(num: Int): String {
        var num = num
        val sb = StringBuilder()
        while (num > 0) {
            sb.append(ALPHABET[num % BASE])
            num /= BASE
        }
        return sb.reverse().toString()
    }

    fun decode(str: String): Int {
        var num = 0
        for (element in str) num = num * BASE + ALPHABET.indexOf(element)
        return num
    }
}