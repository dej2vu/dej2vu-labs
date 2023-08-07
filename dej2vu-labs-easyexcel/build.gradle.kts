plugins {
    java
    id("org.springframework.boot") version libs.versions.spring.boot
}

apply(plugin = "io.spring.dependency-management")

group = "tech.dej2vu"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.alibaba:easyexcel:3.3.2")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.projectlombok:lombok")

    testAnnotationProcessor("org.projectlombok:lombok")
    testImplementation("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit-pioneer:junit-pioneer:2.0.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
    useJUnitPlatform()
}