import com.github.gradle.node.yarn.task.YarnTask

plugins {
    id("com.github.node-gradle.node") version "7.0.2"
}

tasks {
    register<YarnTask>("yarnBuildProd") {
        dependsOn("yarn_install")
        environment.set(mapOf("CI" to "false"))
        args.set(listOf("run", "build:prod"))
    }

    register<YarnTask>("yarnBuildQa") {
        dependsOn("yarn_install")
        environment.set(mapOf("CI" to "false"))
        args.set(listOf("run", "build:qa"))
    }

    register<YarnTask>("yarnBuildDev") {
        dependsOn("yarn_install")
        environment.set(mapOf("CI" to "false"))
        args.set(listOf("run", "build:dev"))
    }

    register<YarnTask>("yarnBuild") {
        dependsOn("yarn_install")
        environment.set(mapOf("CI" to "false"))
        args.set(listOf("run", "build"))
    }
}
