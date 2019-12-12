package com.michalpu.PokeRest

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.tomakehurst.wiremock.junit.WireMockClassRule
import groovy.util.logging.Slf4j
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

import static com.github.tomakehurst.wiremock.client.WireMock.*

@Slf4j
@ContextConfiguration
@ActiveProfiles(profiles = ["integration"])
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

    RestTemplate restTemplate = new RestTemplate()

    def setup() {
        objectMapper.registerModule(new KotlinModule())
    }

    def stubPokemonResponse(int statusCode, String bodyFile = "pokemon.json", String pokemonName = "charmander") {
        try {
            pokemonClient.stubFor(get(urlEqualTo("/pokemon/$pokemonName"))
                    .willReturn(
                            aResponse()
                                    .withStatus(statusCode)
                                    .withBodyFile("pokemon/$bodyFile")
                                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                    ))
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e)
        }
    }

    def stubTypeResponse(int statusCode, String bodyFile = "fire_type.json", String typeName = "fire") {
        try {
            pokemonClient.stubFor(get(urlEqualTo("/type/$typeName"))
                    .willReturn(
                            aResponse()
                                    .withStatus(statusCode)
                                    .withBodyFile("pokemon/$bodyFile")
                                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                    ))
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e)
        }
    }


    String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }
}
