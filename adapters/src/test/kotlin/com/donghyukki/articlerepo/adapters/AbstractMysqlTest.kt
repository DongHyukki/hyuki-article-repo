package com.donghyukki.articlerepo.adapters

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
interface AbstractMysqlTest : KotestSpringContextRunner {

    companion object {
        @Container
        @JvmStatic
        val mysql = MySQLContainer<Nothing>("mysql:8.0.26").apply {
            startupAttempts = 1
            withUrlParam("connectionTimeZone", "Z")
            withUsername("test")
            withPassword("test")
            withDatabaseName("article-repo")
            withReuse(true)
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.r2dbc.url", Companion::r2dbcUrl)
            registry.add("spring.r2dbc.username", mysql::getUsername)
            registry.add("spring.r2dbc.password", mysql::getPassword)

            registry.add("spring.flyway.url", mysql::getJdbcUrl)
            registry.add("spring.flyway.user", mysql::getUsername)
            registry.add("spring.flyway.password", mysql::getPassword)
            registry.add("spring.flyway.locations") { "filesystem:src/main/resources/db/migration/" }
        }

        private fun r2dbcUrl(): String {
            return "r2dbc:mysql://${mysql.host}:${mysql.firstMappedPort}/${mysql.databaseName}"
        }
    }
}
