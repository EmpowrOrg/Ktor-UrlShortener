package dev.empwr.usain.db.dao

import dev.empwr.usain.db.tables.UrlUseTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UrlUseDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UrlUseDao>(UrlUseTable)

    var urlId by UrlUseTable.url
    var date by UrlUseTable.date
}