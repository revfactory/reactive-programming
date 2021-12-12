package kr.revfactory.edge.controller

import kr.revfactory.edge.service.CrmService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
class CrmRestController(private val crmService: CrmService) {

    @GetMapping("/customerProfiles")
    suspend fun customerProfiles() = this.crmService.customerProfiles()

}