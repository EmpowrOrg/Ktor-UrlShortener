package dev.empwr.usain

import dev.empwr.usain.plugins.configureRouting
import dev.empwr.usain.plugins.configureSecurity
import dev.empwr.usain.plugins.configureSerialization
import dev.empwr.usain.db.DatabaseFactory
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = (System.getenv("PORT") ?: "8080").toInt()) {
        configureRouting()
        configureSerialization()
        configureSecurity()
        DatabaseFactory.init()
    }.start(wait = true)
}
