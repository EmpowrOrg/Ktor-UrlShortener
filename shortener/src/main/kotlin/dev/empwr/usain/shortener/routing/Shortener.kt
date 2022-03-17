package dev.empwr.usain.shortener.routing

import dev.empwr.usain.viewutils.toolbar
import kotlinx.css.Color
import kotlinx.css.LinearDimension
import kotlinx.css.backgroundColor
import kotlinx.css.color
import kotlinx.css.paddingLeft
import kotlinx.css.paddingRight
import kotlinx.css.paddingTop
import kotlinx.css.width
import kotlinx.html.HTML
import kotlinx.html.InputType
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.input
import kotlinx.html.link
import kotlinx.html.p
import kotlinx.html.style

fun HTML.shortenerPage(shortenedUrl: String) {
    head {
        link(rel = "stylesheet", href = "/shortenerStyles.css", type = "text/css")
    }
    body(classes = "body-main") {
        style = "margin:0px;"
        header {
            toolbar()
        }
        div(classes = ".content") {
            style = "padding:16px;"
            h1 {
                style = "text-align:center;"
                text("Shortened Url")
            }
            p {
                style = "text-align:center;"
                text(shortenedUrl)
            }
        }
    }
}

/*
rule("navbar-brand") {
    color = Color.white
    paddingLeft = LinearDimension("16px")
}
rule(".content") {
    paddingTop = LinearDimension("60px")
    paddingLeft = LinearDimension("60px")
    paddingRight = LinearDimension("16px")
}
rule("link-input") {
    width = LinearDimension.maxContent
}*/
