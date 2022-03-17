package dev.empwr.usain.models

import dev.empwr.usain.db.dao.UrlDao

data class Url(
    val id: Int,
    val longUrl: String,
    val uses: List<UrlUse>,
    val creationDate: Long,
)

fun UrlDao.toModel(): Url {
    return Url(
        id = id.value,
        longUrl = longUrl,
        uses = uses.toModels(),
        creationDate = creationDate,
    )
}