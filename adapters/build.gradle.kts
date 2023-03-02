dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    compileOnly("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.23")
    implementation(project(":core"))

    testImplementation("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
