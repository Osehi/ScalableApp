pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    /*
    repositories {
        google {
            gradlePluginPortal()
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("com\\.google\\.devtools.*") // 👈 add this line
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()

    }

     */
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DisplayUserName"
include(":app")
 