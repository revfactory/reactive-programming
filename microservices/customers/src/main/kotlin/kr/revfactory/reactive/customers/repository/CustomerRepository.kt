package kr.revfactory.reactive.customers.repository

import kr.revfactory.reactive.customers.domain.Customer
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CustomerRepository : ReactiveCrudRepository<Customer, Long>