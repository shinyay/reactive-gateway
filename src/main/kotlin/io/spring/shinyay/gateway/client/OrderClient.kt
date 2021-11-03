package io.spring.shinyay.gateway.client

import io.spring.shinyay.gateway.entity.Customer
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.util.retry.Retry
import java.time.Duration


@Component
class OrderClient(
    private val rsocket: RSocketRequester? = null,
    private val http: WebClient? = null) {

    fun getCustomers(): Flux<Customer?>? {
        return http!!.get().uri("http://localhost:8080/customers")
            .retrieve()
            .bodyToFlux(Customer::class.java)
            .onErrorResume { ex: Throwable? -> Flux.empty() }
            .retryWhen(Retry.backoff(10, Duration.ofSeconds(1)))
    }

    
}
