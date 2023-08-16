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
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit-pioneer:junit-pioneer:2.0.1") {
        capabilities {
            requireCapability("org.junit-pioneer:junit-pioneer-jackson")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}