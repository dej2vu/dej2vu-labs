plugins {
    java
    id("org.springframework.boot") version libs.versions.spring.boot
}

apply(plugin = "io.spring.dependency-management")

group = "tech.dej2vu"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}