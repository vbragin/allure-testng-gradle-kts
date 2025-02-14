
tasks.withType(Wrapper::class) {
    gradleVersion = "8.5"
}

plugins {
    java
    id("io.qameta.allure") version "2.12.0"
}

group "io.qameta.allure.examples"
version 2.0

val allureVersion = "2.20.0"
val testngVersion = "6.14.3"

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

allure {

}

tasks.withType(Test::class) {
    ignoreFailures = true
    useTestNG {

    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation("io.qameta.allure:allure-java-commons:$allureVersion")

    testImplementation("org.testng:testng:$testngVersion")
    testImplementation("org.slf4j:slf4j-simple:1.7.30")
}
