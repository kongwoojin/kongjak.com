plugins {
    kotlin("multiplatform") version "1.9.0"
}

fun kotlinw(target: String): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"


group = "com.kongjak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

kotlin {
    js {
        browser {
            commonWebpackConfig(Action {
                outputFileName = "index.js"
                cssSupport {
                    enabled.set(true)
                }
            })
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            val wrappersVersion = extra["kotlin.wrappers.version"]
            dependencies {
                implementation(enforcedPlatform(kotlinw("wrappers-bom:$wrappersVersion")))

                implementation(kotlinw("react"))
                implementation(kotlinw("react-dom"))
                implementation(kotlinw("emotion"))

                implementation(kotlinw("mui"))
                implementation(kotlinw("mui-icons"))

                implementation(npm("date-fns", "2.30.0"))
                implementation(npm("@date-io/date-fns", "2.17.0"))
            }
        }
        val jsTest by getting
    }
}
