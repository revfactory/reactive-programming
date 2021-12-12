package kr.revfactory.reactive.profiles.controller

import kr.revfactory.api.core.domain.profile.Profile
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@Controller
class ProfileRSocketController {
    private val db: ConcurrentMap<Long, Profile> = ConcurrentHashMap()
    init {
        var ctr = 0L
        for (customerId in 1L..2) {
            ctr += 1
            db[customerId] =Profile(ctr, LocalDateTime.now())
        }
    }

    @MessageMapping("profiles.{customerId}")
    fun getProfileFor(@DestinationVariable customerId: Long): Mono<Profile> {
        return Mono.just(db[customerId]!!)
    }
}