package com.donghyukki.articlerepo.adapters

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.test.context.ActiveProfiles

@ConditionalOnProperty("spring.flyway.url")
@ActiveProfiles("test")
@Configuration
@Order(1)
class FlyWayConfig(
    flyway: Flyway
) {
    init {
        flyway.migrate()
    }
}
