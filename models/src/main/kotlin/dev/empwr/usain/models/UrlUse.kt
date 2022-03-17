package dev.empwr.usain.models

import dev.empwr.usain.db.dao.UrlUseDao
import org.jetbrains.exposed.sql.SizedIterable

data class UrlUse(
    val urlId: Int,
    val date: Long,
)

fun UrlUseDao.toModel(): UrlUse {
    return UrlUse(
        urlId = urlId.value,
        date = date,
    )
}

fun SizedIterable<UrlUseDao>.toModels(): List<UrlUse> {
    return map {
        it.toModel()
    }
}