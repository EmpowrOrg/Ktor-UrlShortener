package dev.empwr.usain.frontend.routing

import dev.empwr.usain.frontend.mainPage
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.frontendRouting() {
    routing {
        get("/shorten") {
            call.respondHtml {
                mainPage()
            }
        }
    }
}