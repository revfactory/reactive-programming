package kr.revfactory.reactive.customers.repository

import kr.revfactory.api.core.domain.customer.Customer
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CustomerRepository : ReactiveCrudRepository<Customer, Long>