plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(Deps.Exposed.core)
    implementation(Deps.Exposed.jdbc)
    implementation(Deps.Exposed.dao)
    implementation(Deps.Hikari.main)
    implementation(Deps.Postgresql.main)
}