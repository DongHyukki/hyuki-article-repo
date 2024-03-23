package com.donghyukki.articlerepo.adapters.out.db.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = ["com.donghyukki.articlerepo.adapters.out.db.repository"])
class R2dbcConfig
