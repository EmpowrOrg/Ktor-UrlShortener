plugins {
    application
    kotlin("jvm") version Versions.kotlin
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "dev.empwr.usain"
version = ConfigData.appVersion

application {
    mainClass.set("dev.empwr.usain.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("usain.jar")
    archiveVersion.set(ConfigData.appVersion)
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "dev.empwr.usain.ApplicationKt"
            )
        )
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(project(Deps.Project.frontend))
    implementation(project(Deps.Project.db))
    implementation(project(Deps.Project.shortener))
    implementation(Deps.Ktor.core)
    implementation(Deps.Kotlin.html)
    implementation(Deps.Ktor.html)
    implementation(Deps.Kotlin.css)
    implementation(Deps.Ktor.contentNegotiation)
    implementation(Deps.Ktor.serialization)
    implementation(Deps.Ktor.auth)
    implementation(Deps.Ktor.netty)
    implementation(Deps.Ktor.httpsRedirect)
    implementation(Deps.Logback.main)
    testImplementation(Deps.Ktor.tests)
    testImplementation(Deps.Kotlin.test)
}