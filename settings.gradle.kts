plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "ByteCupids-Backend"
include("main-app", "shared-domain", "user-module", "admin-module", "infrastructure")