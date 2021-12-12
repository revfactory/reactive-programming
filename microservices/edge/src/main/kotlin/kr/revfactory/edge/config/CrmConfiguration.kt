package kr.revfactory.edge.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class CrmConfiguration {

    @Bean
    fun rsocket(rsb: RSocketRequester.Builder) = rsb.tcp("localhost", 7003)

    @Bean
    fun http(wcb: WebClient.Builder) = wcb.build()
}
