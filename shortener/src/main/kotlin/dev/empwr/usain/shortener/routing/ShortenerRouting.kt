package dev.empwr.usain.shortener.routing

import io.ktor.http.ContentType
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.LinearDimension
import kotlinx.css.backgroundColor
import kotlinx.css.color
import kotlinx.css.margin
import kotlinx.css.paddingLeft
import kotlinx.css.paddingRight
import kotlinx.css.paddingTop
import kotlinx.css.px
import kotlinx.css.width

fun Application.shortenerRouting() {
    val viewModel = RealShortenerViewModel()
    routing {
        shortenerPage()
        createShortenedUrl(viewModel)
        redirect(viewModel)
    }
}

internal fun Routing.redirect(viewModel: ShortenerViewModel) {
    get("/a/{path}") {
        val path = call.parameters["path"] ?: run {
            call.respondRedirect("/shorten")
            return@get
        }
        val redirectUrl = viewModel.unshorten(path) ?: run {
            call.respondRedirect("/shorten")
            return@get
        }
        call.respondRedirect(redirectUrl)
    }
}

internal fun Routing.shortenerPage() {
    get("/shortener") {
        val url = call.parameters["url"] ?: run {
            call.respondRedirect("/shorten")
            return@get
        }
        call.respondHtml {
            shortenerPage(url)
        }
    }
}

internal fun Routing.createShortenedUrl(viewModel: ShortenerViewModel) {
    post("/shortener") {
        val longUrl = call.receiveParameters()["url"]
        val url = viewModel.shorten(longUrl)
        if (url == null) {
            call.respondRedirect("/shortener")
            return@post
        }
        call.respondRedirect {
            this.parameters["url"] = url
        }
    }
}

private suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}