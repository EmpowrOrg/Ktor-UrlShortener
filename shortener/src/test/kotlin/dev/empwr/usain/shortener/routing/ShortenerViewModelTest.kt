package dev.empwr.usain.shortener.routing

import dev.empwr.usain.models.Url
import dev.empwr.usain.shortener.fakes.FakeShortenerRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ShortenerViewModelTest {

    private val repo = FakeShortenerRepository()
    private val baseUri = "https://empwr.dev/"

    @Test
    fun longUrlIsNullOrBlank() = runBlocking {
        val viewModel = RealShortenerViewModel(repo, baseUri)
        var result = viewModel.shorten(null)
        assertEquals(null, result)
        result = viewModel.shorten("   ")
        assertEquals(null, result)
        assertTrue(repo.urls.isEmpty())
        assertTrue(repo.uses.isEmpty())
    }

    @Test
    fun getExistingUrlIfExists() = runBlocking {
        val url = Url(
            id = 1,
            longUrl = "https://empowrco.org",
            uses = emptyList(),
            creationDate = System.currentTimeMillis(),
        )
        repo.urls.add(url)
        val viewModel = RealShortenerViewModel(repo, baseUri)
        val result = viewModel.shorten(url.longUrl)
        assertEquals("https://empwr.dev/b", result)
        assertTrue(repo.urls.isEmpty())
        assertTrue(repo.uses.isEmpty())
    }

    @Test
    fun saveUrlIfDoesNotExist() = runBlocking {
        val viewModel = RealShortenerViewModel(repo, baseUri)
        val longUrl = "https://empowrco.org/the-royalty-program"
        val result = viewModel.shorten(longUrl)
        val url = repo.urls.removeFirst()
        assertEquals(url.longUrl, longUrl)
        assertEquals(url.id, 1)
        assertEquals(url.uses, emptyList())
        assertEquals("https://empwr.dev/b", result)
        assertTrue(repo.urls.isEmpty())
        assertTrue(repo.uses.isEmpty())
    }

    @Test
    fun shortUrlIsNullOrBlank() = runBlocking {
        val viewModel = RealShortenerViewModel(repo, baseUri)
        assertEquals(viewModel.unshorten(null), null)
        assertEquals(viewModel.unshorten("   "), null)
        assertTrue(repo.uses.isEmpty())
        assertTrue(repo.urls.isEmpty())
    }

    @Test
    fun urlDoesNotExist() = runBlocking {
        val url = Url(
            id = 1,
            longUrl = "https://empowrco.org",
            uses = emptyList(),
            creationDate = System.currentTimeMillis(),
        )
        repo.urls.add(url)
        val viewModel = RealShortenerViewModel(repo, baseUri)
        assertEquals(viewModel.unshorten("https://empwr.dev"), null)
    }

    @Test
    fun unshortenUrl() = runBlocking {
        val url = Url(
            id = 1,
            longUrl = "https://empowrco.org/the-royalty-program",
            uses = emptyList(),
            creationDate = System.currentTimeMillis(),
        )
        repo.urls.add(url)
        val viewModel = RealShortenerViewModel(repo, baseUri)
        assertEquals(viewModel.unshorten("b"), url.longUrl)
        assertTrue(repo.urls.isEmpty())
        assertTrue(repo.uses.isNotEmpty())
    }
}