package com.michalpu.PokeRest.client

import io.vavr.control.Try
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestOperations

@Service
class PokemonClientImpl(val pokemonApiRestTemplate: RestOperations,
                        @Value("\${poke.api.host}") val pokemonApiHostUrl: String) : PokemonClient {

    override fun getByName(name: String): Pokemon {
        return Try.of { pokemonApiRestTemplate.getForObject("$pokemonApiHostUrl/pokemon/$name", Pokemon::class.java)!! }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get()

    }

    private fun mapToDomain(response: Pokemon) = Pokemon(response.id, response.name, response.weight)

    }
