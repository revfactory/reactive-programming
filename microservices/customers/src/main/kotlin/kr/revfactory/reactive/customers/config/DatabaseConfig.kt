package kr.revfactory.reactive.customers.config

import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager

@Configuration
@EnableR2dbcRepositories
class DatabaseConfig: AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory = H2ConnectionFactory.inMemory("testdb")

    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager = R2dbcTransactionManager(connectionFactory);
}