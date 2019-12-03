package com.michalpu.PokeRest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.tomakehurst.wiremock.junit.WireMockClassRule
import org.junit.ClassRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration
@ActiveProfiles(value = ["integration"])
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class BaseIntegrationTest extends Specification {


    @Shared
    @ClassRule
    WireMockClassRule pokemonClient = new WireMockClassRule(8090)

    @Autowired
    ObjectMapper objectMapper

    @LocalServerPort
    int port

    RestTemplate restTemplate

    def setup() {
        objectMapper.registerModule(new KotlinModule())
    }

    def stubPokemonClient(int statusCode, String bodyFile = "pokemon.json") {
        pokemonClient.stubFor(get(urlEqualTo("pokemon"))
                .willReturn(
                        aResponse()
                                .withStatus(statusCode)
                                .withBodyFile("pokemon/$bodyFile")
                                .withHeaders(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                ))
    }

    String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }
}
