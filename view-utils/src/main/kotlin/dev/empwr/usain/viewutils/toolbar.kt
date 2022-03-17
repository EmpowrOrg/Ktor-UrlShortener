package dev.empwr.usain.viewutils

import kotlinx.html.HEADER
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.nav
import kotlinx.html.style

fun HEADER.toolbar() {
    nav(classes = "navbar navbar-default navbar-fixed-top") {
        style = "background-color:#5D0E81;padding:16px;"
        div(classes = "product") {
            a(href = "/shorten", classes = "navbar-brand") {
                style = "font-size:1.5em;color:white;text-decoration:none;"
                text("EMPOWR")
            }
        }
    }
}
