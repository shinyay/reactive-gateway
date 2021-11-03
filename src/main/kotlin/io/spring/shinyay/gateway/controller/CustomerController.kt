package io.spring.shinyay.gateway.controller

import io.spring.shinyay.gateway.client.OrderClient
import io.spring.shinyay.gateway.entity.Customer
import io.spring.shinyay.gateway.entity.CustomerOrders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class CustomerController {
    private val client: OrderClient? = null

    @GetMapping("/customer")
    fun get(): Flux<Customer?>? {
        return client?.getCustomers()
    }
}
