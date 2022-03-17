package dev.empwr.usain.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.dao.id.UUIDTable

object UrlUseTable: IntIdTable() {
    val date = long("date")
    val url = reference("url", UrlTable)
}