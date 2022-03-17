package dev.empwr.usain.plugins

import dev.empwr.usain.frontend.routing.frontendRouting
import dev.empwr.usain.shortener.routing.shortenerRouting
import io.ktor.server.application.Application

fun Application.configureRouting() {
    frontendRouting()
    shortenerRouting()
}
