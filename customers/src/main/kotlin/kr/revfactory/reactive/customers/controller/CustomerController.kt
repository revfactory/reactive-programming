package kr.revfactory.reactive.customers.controller

import kr.revfactory.reactive.customers.domain.Customer
import kr.revfactory.reactive.customers.repository.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class CustomerController(val customerRepository: CustomerRepository) {

    @GetMapping("/customers")
    fun getCustomers() : Flux<Customer> = this.customerRepository.findAll()

}