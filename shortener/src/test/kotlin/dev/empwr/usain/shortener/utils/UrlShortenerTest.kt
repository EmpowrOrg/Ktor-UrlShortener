package dev.empwr.usain.shortener.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class UrlShortenerTest {

    private val pathIndexes = mapOf(43453455 to "c6uol", 0 to "", 1 to "b")

    @Test
    fun encodeTest() {
        pathIndexes.forEach { key, value ->
            assertEquals(value, UrlShortener.encode(key))
        }
    }

    @Test
    fun decodeTest() {
        pathIndexes.forEach { key, value ->
            assertEquals(key, UrlShortener.decode(value))
        }
    }
}