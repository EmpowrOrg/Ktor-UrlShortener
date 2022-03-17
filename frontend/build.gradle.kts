plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(Deps.Project.viewUtils))
    implementation(Deps.Ktor.core)
    implementation(Deps.Kotlin.html)
    implementation(Deps.Ktor.html)
    implementation(Deps.Kotlin.css)
}