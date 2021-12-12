package kr.revfactory.edge.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.revfactory.api.core.domain.customer.Customer
import kr.revfactory.api.core.domain.profile.Profile
import kr.revfactory.edge.dto.CustomerProfile
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.retrieveAndAwait
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow

@Service
class CrmService(
    private val http: WebClient,
    private val rsocket: RSocketRequester
) {
    suspend fun customers(): Flow<Customer> =
        this.http.get().uri("http://localhost:7001/customers").retrieve()
            .bodyToFlow()

    suspend fun profileFor(customerId: Long): Profile =
        this.rsocket.route("profiles.{cid}", customerId)
            .retrieveAndAwait()

    suspend fun customerProfiles(): Flow<CustomerProfile> =
        this.customers()
            .map { customer ->
                val profile = this.profileFor(customer.id)
                CustomerProfile(customer, profile)
            }
}