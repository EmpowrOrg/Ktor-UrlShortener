package dev.empowr.usain.sources

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

internal suspend fun <T> dbQuery(block: () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) {
        if (System.getenv("environment").contentEquals("debug", ignoreCase = true)) {
            addLogger(StdOutSqlLogger)
        }
        block()
    }