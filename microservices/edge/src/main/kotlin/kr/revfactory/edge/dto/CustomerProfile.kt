package kr.revfactory.edge.dto

import kr.revfactory.api.core.domain.customer.Customer
import kr.revfactory.api.core.domain.profile.Profile

data class CustomerProfile(val customer: Customer, val profile: Profile)