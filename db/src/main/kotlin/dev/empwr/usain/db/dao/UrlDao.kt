package dev.empwr.usain.db.dao

import dev.empwr.usain.db.tables.UrlTable
import dev.empwr.usain.db.tables.UrlUseTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UrlDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UrlDao>(UrlTable)
    var longUrl by UrlTable.longUrl
    var creationDate by UrlTable.creationDate
    val uses by UrlUseDao referrersOn UrlUseTable.url
}