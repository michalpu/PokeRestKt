package com.michalpu.PokeRest.client

import io.vavr.control.Try
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import java.lang.NullPointerException


class PokemonClientImpl(val pokemonApiRestTemplate: RestTemplate,
                        val url: String) : PokemonClient {

    companion object {
        private const val PATH = "pokemon"
    }

    override fun getByName(name: String): Pokemon {
        return Try.of { pokemonApiRestTemplate.getForObject("$url/$PATH/$name", Pokemon::class.java)!! }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get() ?: throw PokemonClientException(KotlinNullPointerException())

    }

    private fun mapToDomain(response: Pokemon) = Pokemon(response.id, response.name, response.weight)

}
