import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // desktop compose 1.0.0 is not yet compatible with Kotlin 1.6
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
    // Jacoco plugins, see https://docs.gradle.org/current/userguide/jacoco_plugin.html
    jacoco
    id("org.barfuin.gradle.jacocolog") version "2.0.0"
}

group = "net.speciesm.draget"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.assertj:assertj-core:3.21.0")
}

tasks.withType<Test>() {
    finalizedBy(tasks.jacocoTestReport)
    useJUnitPlatform()
}

// Kotlin and Java need to compile to JVM 16, because compose is not yet compatible with 17
tasks.withType<JavaCompile>() {
    java {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions {
        jvmTarget = "16"
    }
}

compose.desktop {
    application {
        mainClass = "net.speciesm.draget.AoC2021Kt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = rootProject.name
            packageVersion = "1.0.0"
        }
    }
}
