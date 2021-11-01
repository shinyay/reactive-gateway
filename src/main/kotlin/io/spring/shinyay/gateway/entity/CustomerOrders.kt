package io.spring.shinyay.gateway.entity

data class CustomerOrders(val customer: Customer, val orders: List<Order>)
