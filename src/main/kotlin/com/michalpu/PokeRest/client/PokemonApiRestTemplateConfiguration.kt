package com.michalpu.PokeRest.client

import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class PokemonApiRestTemplateConfiguration {

    @Bean("pokemonRestTemplate")
    fun getPokemonApiRestTemplate(
            @Value("\${poke.client.connectionTimeout}") connectionTimeout: Int,
            @Value("\${poke.client.connectionRequestTimeout}") connectionRequestTimeout: Int,
            @Value("\${poke.client.readTimeout}") readTimeout: Int,
            @Value("\${poke.client.maxConnectionTotal}") maxConnectionTotal: Int,
            @Value("\${poke.client.maxConnectionPerRoute}") maxConnectionPerRoute: Int): RestTemplate =
            RestTemplate(httpFactory(
                    connectionTimeout,
                    connectionRequestTimeout,
                    readTimeout,
                    maxConnectionTotal,
                    maxConnectionPerRoute
            ))

    @Bean
    fun pokemonClient(
            @Qualifier("pokemonRestTemplate") restTemplate: RestTemplate,
            @Value("\${poke.client.host}") url: String) =
            PokemonClientImpl(restTemplate, url)


    private fun httpFactory(connectionTimeout: Int,
                            connectionRequestTimeout: Int,
                            readTimeout: Int,
                            maxConnectionTotal: Int,
                            maxConnectionPerRoute: Int): HttpComponentsClientHttpRequestFactory{

        val requestConfig = HttpComponentsClientHttpRequestFactory()
        requestConfig.setConnectTimeout(connectionTimeout)
        requestConfig.setConnectionRequestTimeout(connectionRequestTimeout)
        requestConfig.setReadTimeout(readTimeout)
        requestConfig.httpClient = getConfiguredHttpClient(maxConnectionTotal, maxConnectionPerRoute)

        return requestConfig
    }

    private fun getConfiguredHttpClient (maxConnectionTotal: Int, maxConnectionPerRoute: Int) =
            HttpClientBuilder.create()
                    .setMaxConnTotal(maxConnectionTotal)
                    .setMaxConnPerRoute(maxConnectionPerRoute)
                    .build()


}