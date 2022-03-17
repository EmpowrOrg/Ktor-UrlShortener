package dev.empwr.usain.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.dao.id.UUIDTable

object UrlTable: IntIdTable() {
    val longUrl = text("long_url").uniqueIndex()
    val creationDate = long("creation_date")
}