plugins {
    kotlin("jvm")
}

group = "dev.empwr"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(Deps.Project.models))
    implementation(project(Deps.Project.db))
    implementation(Deps.Exposed.dao)
}