plugins {
    id("org.flywaydb.flyway") version "9.8.1"
}

val kotestSpringExtensionVersion = "1.1.2"
val kotestTestContainerExtensionVersion = "1.3.4"

dependencies {
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql:8.5.13")

    implementation("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.23")
    implementation("org.jsoup:jsoup:1.15.4")

    testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestSpringExtensionVersion")
    testImplementation("io.kotest.extensions:kotest-extensions-testcontainers:$kotestTestContainerExtensionVersion")

    testImplementation("org.testcontainers:junit-jupiter:1.17.6")
    testImplementation("org.testcontainers:mysql:1.17.6")
    testImplementation("org.testcontainers:r2dbc:1.17.6")
    testRuntimeOnly("com.mysql:mysql-connector-j")
}

buildscript {
    dependencies {
        classpath("org.flywaydb:flyway-mysql:8.5.13")
    }
}

flyway {
    url = "jdbc:mysql://localhost:3308?useSSL=false&allowPublicKeyRetrieval=true"
    user = "root"
    password = "root"
    locations = arrayOf("filesystem:src/main/resources/db/migration/")
    schemas = arrayOf("article-repo")
    createSchemas = true
    encoding = "utf8"
    baselineOnMigrate = true
    cleanDisabled = false
    failOnMissingLocations = true
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
