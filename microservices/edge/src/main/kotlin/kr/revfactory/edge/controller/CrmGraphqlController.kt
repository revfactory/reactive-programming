package kr.revfactory.edge.controller

import kr.revfactory.api.core.domain.customer.Customer
import kr.revfactory.api.core.domain.profile.Profile
import kr.revfactory.edge.service.CrmService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class CrmGraphqlController(private val crmService: CrmService) {
    @SchemaMapping(typeName = "Profile")
    fun registered(p: Profile): String = p.registered.toString()

    @SchemaMapping(typeName = "Customer")
    suspend fun profile(c: Customer) = this.crmService.profileFor(c.id)

    @QueryMapping
    suspend fun customers() = this.crmService.customers()
}