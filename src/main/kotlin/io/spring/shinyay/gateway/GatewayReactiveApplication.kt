package io.spring.shinyay.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GatewayReactiveApplication {

    @Bean
    fun gateway(rlb: RouteLocatorBuilder) = rlb.routes()
        .route { r ->
            r.path("/proxy").and().host("*.spring.io")
                .filters { f -> f.setPath("/customers") }
                .uri("http://localhost:8080")
        }.build()
}

fun main(args: Array<String>) {
    runApplication<GatewayReactiveApplication>(*args)
}
