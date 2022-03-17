package dev.empowr.usain.sources

import dev.empwr.usain.db.dao.UrlDao
import dev.empwr.usain.db.dao.UrlUseDao
import dev.empwr.usain.db.tables.UrlTable
import dev.empwr.usain.models.Url
import dev.empwr.usain.models.UrlUse
import dev.empwr.usain.models.toModel
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

interface UrlSource {
    suspend fun saveUrl(url: Url): Int
    suspend fun getUrl(index: Int): Url?
    suspend fun addUse(urlUse: UrlUse)
    suspend fun getUrl(longUrl: String): Url?
}

class RealUrlSource: UrlSource {
    override suspend fun saveUrl(url: Url): Int = dbQuery {
        try {
            val urlDao = UrlDao.new {
                longUrl = url.longUrl
                creationDate = url.creationDate
            }
            UrlUseDao.new {
                this.urlId = urlDao.id
                date = urlDao.creationDate
            }
            return@dbQuery urlDao.id.value
        } catch (ex: Exception) {
            println(ex.localizedMessage)
        }
        return@dbQuery 0
    }

    override suspend fun getUrl(index: Int): Url? = dbQuery {
        return@dbQuery UrlDao.findById(index)?.toModel()
    }

    override suspend fun getUrl(longUrl: String): Url? = dbQuery {
        return@dbQuery UrlDao.find { UrlTable.longUrl eq longUrl }.firstOrNull()?.toModel()
    }

    override suspend fun addUse(urlUse: UrlUse) = dbQuery {
        val url = UrlDao.findById(urlUse.urlId) ?: return@dbQuery
        UrlUseDao.new {
            urlId = url.id
            date = urlUse.date
        }
    }
}