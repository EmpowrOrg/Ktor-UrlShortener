package dev.empwr.usain.shortener.routing

import dev.empowr.usain.sources.RealUrlSource
import dev.empowr.usain.sources.UrlSource
import dev.empwr.usain.models.Url
import dev.empwr.usain.models.UrlUse

internal interface ShortenerRepository {
    suspend fun getUrl(index: Int): Url?
    suspend fun saveUrl(url: Url): Int
    suspend fun getUrl(longUrl: String): Url?
    suspend fun addUse(use: UrlUse)
}

internal class RealShortenerRepository(private val urlSource: UrlSource = RealUrlSource()): ShortenerRepository {
    override suspend fun getUrl(index: Int): Url? {
        return urlSource.getUrl(index)
    }

    override suspend fun getUrl(longUrl: String): Url? {
        return urlSource.getUrl(longUrl)
    }

    override suspend fun saveUrl(url: Url): Int {
        return urlSource.saveUrl(url)
    }

    override suspend fun addUse(use: UrlUse) {
        urlSource.addUse(use)
    }
}