package dev.empwr.usain.shortener.fakes

import dev.empwr.usain.models.Url
import dev.empwr.usain.models.UrlUse
import dev.empwr.usain.shortener.routing.ShortenerRepository

class FakeShortenerRepository: ShortenerRepository {
    val urls = mutableListOf<Url>()
    val uses = mutableListOf<UrlUse>()
    override suspend fun getUrl(index: Int): Url? {
        val adjustedIndex = index - 1 // need to adjust because databases start at 1 but arrays start at 0
        if (adjustedIndex > urls.lastIndex) {
            return null
        }
        return urls.removeAt(adjustedIndex)
    }

    override suspend fun saveUrl(url: Url): Int {
        urls.add(url)
        return urls.indexOf(url) + 1 // we never want to work with zero
    }

    override suspend fun getUrl(longUrl: String): Url? {
        val url = urls.find { it.longUrl == longUrl }
        url?.let { urls.remove(it) }
        return url
    }

    override suspend fun addUse(use: UrlUse) {
        uses.add(use)
    }
}