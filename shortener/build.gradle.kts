plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(Deps.Project.viewUtils))
    implementation(project(Deps.Project.sources))
    implementation(project(Deps.Project.models))
    implementation(Deps.Ktor.core)
    implementation(Deps.Kotlin.html)
    implementation(Deps.Ktor.html)
    implementation(Deps.Kotlin.css)
    testImplementation(Deps.Ktor.tests)
    testImplementation(Deps.Kotlin.test)
}