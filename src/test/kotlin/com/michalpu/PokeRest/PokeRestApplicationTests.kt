package com.michalpu.PokeRest

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.michalpu.PokeRest.domain.Pokemon
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

@ActiveProfiles(profiles = ["integration"])
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokeRestApplicationTests {

    companion object {
        val logger = LoggerFactory.getLogger(PokeRestApplicationTests::class.java)
    }

    val restTemplate = RestTemplate()

    @LocalServerPort
    var port: Int = 8089

    @Rule
    val pokeClientRule = WireMockRule(8089)

    fun stubPokeClient(statusCode: Int, id: Long, name: String, weight: Int) {
        val stubbedPokemon = Pokemon(id, name, weight)
        val objectMapper = ObjectMapper()
        try {
            pokeClientRule.stubFor(get(WireMock.urlEqualTo("/pokemon/${name}"))
                    .willReturn(aResponse()
                            .withStatus(statusCode)
                            .withHeader("Content-Type", "application/json")
                            .withBody(
                                    objectMapper.writeValueAsString(stubbedPokemon)
                            )))
        } catch (e: JsonProcessingException) {
            logger.error(e.originalMessage, e)
        }


    }

    @Test
    fun contextLoads() {
    }

    fun localUrl(path: String) = "http://localhost:" + port + path

}
