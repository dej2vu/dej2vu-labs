rootProject.name = "dej2vu-labs"
include("dej2vu-labs-easyexcel")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("spring-boot", "3.1.2")
        }
    }
}
include("dej2vu-test-spring-boot-starter")
