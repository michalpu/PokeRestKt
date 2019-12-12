package com.michalpu.PokeRest.client

import io.vavr.control.Try
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate


class PokemonClientImpl(val pokemonApiRestTemplate: RestTemplate,
                        val url: String) : PokemonClient {

    companion object {
        private const val POKEMON_PATH = "pokemon"
        private const val TYPE_PATH = "type"
    }


    override fun getPokemonByName(name: String): Pokemon {
        return Try.of { pokemonApiRestTemplate.getForObject("$url/$POKEMON_PATH/$name", Pokemon::class.java) }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get() ?: throw PokemonClientException(KotlinNullPointerException())

    }

    override fun getTypesOfPokemon(pokemon: Pokemon): List<Type> {
        return pokemon.types.map { getTypeByName(it.type.name) }
    }

    override fun getTypeByName(name: String): Type {
        return Try.of {
            pokemonApiRestTemplate.getForObject("$url/$TYPE_PATH/$name", Type::class.java)!! }
                .onFailure(HttpServerErrorException::class.java) { throw PokemonClientException(it) }
                .map { mapToDomain(it) }
                .get()
    }

    private fun mapToDomain(response: Pokemon?)= response?.let{
        Pokemon(it.id, it.name, it.weight, it.types)
    }

    private fun mapToDomain(response: Type) = Type(response.id, response.name, response.relations)


}
