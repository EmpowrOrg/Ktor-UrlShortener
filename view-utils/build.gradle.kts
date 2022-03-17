plugins {
    kotlin("jvm")
}

group = "dev.empwr"
version = "0.0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(Deps.Ktor.core)
    implementation(Deps.Kotlin.html)
    implementation(Deps.Ktor.html)
    implementation(Deps.Kotlin.css)
}