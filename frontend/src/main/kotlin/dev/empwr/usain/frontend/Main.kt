package dev.empwr.usain.frontend

import dev.empwr.usain.viewutils.toolbar
import kotlinx.html.ButtonType
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.HTML
import kotlinx.html.InputType
import kotlinx.html.body
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.input
import kotlinx.html.link
import kotlinx.html.style


internal fun HTML.mainPage()  {
    body {
        style = "margin:0px;"
        header {
            toolbar()
        }
        div(classes = "content") {

            h1 {
                style = "text-align:center;"
                text("EMPOWR")
            }
            form(method = FormMethod.post, action = "/shortener", encType = FormEncType.multipartFormData) {
                style = "text-align:center;"
                input(classes = "link-input", type = InputType.url, name = "url") {
                    style = "width:50%;"
                    placeholder = "https://empowrco.org/the-royalty-program"
                    autoComplete = false
                }
                button(type = ButtonType.submit) {
                    style = "margin-top:16px;display:block;margin-left:auto;margin-right:auto;"
                    text("Submit")
                }
            }
        }
    }
}

