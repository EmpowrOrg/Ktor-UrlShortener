package dev.empwr.usain.shortener.routing

import dev.empwr.usain.models.Url
import dev.empwr.usain.models.UrlUse
import dev.empwr.usain.shortener.utils.UrlShortener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URI

internal interface ShortenerViewModel {
    suspend fun shorten(longUrl: String?): String?
    suspend fun unshorten(shortUrl: String?): String?
}

internal class RealShortenerViewModel(
    private val repo: ShortenerRepository = RealShortenerRepository(),
    private val baseUri: String = System.getenv("BASE_URL"),
) : ShortenerViewModel {

    override suspend fun shorten(longUrl: String?): String? = withContext(Dispatchers.IO) {
        if (longUrl.isNullOrBlank()) {
            return@withContext null
        }
        val normalizedUrl = URI.create(longUrl).normalize().toString().removeSuffix("/")
        repo.getUrl(normalizedUrl)?.let {
            return@withContext createUrl(it.id)
        }

        val index = repo.saveUrl(
            Url(
                id = 1, // id is overwritten by database
                longUrl = normalizedUrl,
                uses = emptyList(),
                creationDate = System.currentTimeMillis(),
            )
        )

        return@withContext createUrl(index)
    }

    private fun createUrl(index: Int): String {
        val shortPath = UrlShortener.encode(index)
        return URI.create(baseUri).resolve(shortPath).toString()
    }

    override suspend fun unshorten(shortUrl: String?): String? = withContext(Dispatchers.IO) {
        if (shortUrl.isNullOrBlank()) {
            return@withContext null
        }
        val decodedIndex = UrlShortener.decode(shortUrl)
        val url = repo.getUrl(decodedIndex)
        url ?: return@withContext null
        launch {
            repo.addUse(
                UrlUse(
                    urlId = url.id,
                    date = System.currentTimeMillis()
                )
            )
        }
        return@withContext url.longUrl
    }
}