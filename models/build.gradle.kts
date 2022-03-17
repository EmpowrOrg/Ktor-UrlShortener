plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(Deps.Project.db))
    implementation(Deps.Exposed.dao)
}