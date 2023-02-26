dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    compileOnly("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.23")
    implementation(project(":core"))
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
