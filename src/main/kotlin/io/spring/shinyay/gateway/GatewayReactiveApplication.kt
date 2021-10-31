package io.spring.shinyay.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GatewayReactiveApplication

fun main(args: Array<String>) {
	runApplication<GatewayReactiveApplication>(*args)
}
