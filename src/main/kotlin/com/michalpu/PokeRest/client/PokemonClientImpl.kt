package com.michalpu.PokeRest.client

import io.vavr.control.Try
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate


class PokemonClientImpl(val pokemonApiRestTemplate: RestTemplate,
                        val url: String) : PokemonClient {

    companion object {
        private const val PATH = "pokemon"
    }

    override fun getPokemonByName(name: String): Pokemon {
        return Try.of { pokemonApiRestTemplate.getForObject("$url/$PATH/$name", Pokemon::class.java)!! }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get()

    }

    override fun getTypeByName(name: String): Type {
        return Try.of {
            pokemonApiRestTemplate.getForObject("https://pokeapi.co/api/v2/type/$name", Type::class.java)!! }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get()
    }

    private fun mapToDomain(response: Pokemon) = Pokemon(response.id, response.name, response.weight, response.types)

    private fun mapToDomain(response: Type) = Type(response.id, response.name, response.typeRelations)

}
