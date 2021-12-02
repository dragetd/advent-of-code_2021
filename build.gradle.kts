plugins {
    kotlin("multiplatform") version "1.5.10"
}

group = "net.speciesm.draget"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    var hostOs = System.getProperty("os.name")
    if (hostOs.startsWith("Windows")) hostOs = "Windows"
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        hostOs == "Windows" -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }
}
