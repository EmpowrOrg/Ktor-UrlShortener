object Deps {

    object Project {
        val db by lazy { ":db" }
        val frontend by lazy { ":frontend" }
        val sources by lazy { ":sources" }
        val shortener by lazy { ":shortener" }
        val models by lazy { ":models" }
        val viewUtils by lazy { ":view-utils" }
    }

    object Exposed {
        val core by lazy { "org.jetbrains.exposed:exposed-core:${Versions.exposed}" }
        val dao by lazy { "org.jetbrains.exposed:exposed-dao:${Versions.exposed}" }
        val jdbc by lazy { "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}" }
    }

    object Ktor {
        val contentNegotiation by lazy { "io.ktor:ktor-server-content-negotiation-jvm:${Versions.ktor}" }
        val auth by lazy { "io.ktor:ktor-server-auth-jvm:${Versions.ktor}" }
        val serialization by lazy { "io.ktor:ktor-serialization-kotlinx-json-jvm:${Versions.ktor}" }
        val netty by lazy { "io.ktor:ktor-server-netty-jvm:${Versions.ktor}" }
        val html by lazy { "io.ktor:ktor-server-html-builder-jvm:${Versions.ktor}" }
        val core by lazy { "io.ktor:ktor-server-core-jvm:${Versions.ktor}" }
        val tests by lazy { "io.ktor:ktor-server-tests-jvm:${Versions.ktor}" }
        val httpsRedirect by lazy { "io.ktor:ktor-server-http-redirect:${Versions.ktor}" }
    }

    object Kotlin {
        val html by lazy { "org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3" }
        val css by lazy { "org.jetbrains:kotlin-css-jvm:1.0.0-pre.129-kotlin-1.4.20" }
        val test by lazy { "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}" }
    }

    object Logback {
        val main by lazy { "ch.qos.logback:logback-classic:${Versions.logback}" }
    }

    object Hikari {
        val main by lazy { "com.zaxxer:HikariCP:5.0.1" }
    }

    object Postgresql {
        val main by lazy { "org.postgresql:postgresql:42.3.1" }
    }
}
