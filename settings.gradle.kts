rootProject.name = "usain"
include("frontend")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
include("shortener")
include("view-utils")
include("db")
include("models")
include("sources")
