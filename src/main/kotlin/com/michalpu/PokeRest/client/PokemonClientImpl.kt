package com.michalpu.PokeRest.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestOperations

@Service
class PokemonClientImpl(val pokemonApiRestTemplate: RestOperations,
                        @Value("\${poke.api.host}") val pokemonApiHostUrl: String): PokemonClient {

    override fun getByName(name: String): Pokemon? {
        val response =
                pokemonApiRestTemplate.getForEntity("$pokemonApiHostUrl/pokemon/$name", Pokemon::class.java)

        if (response.hasBody()){
            return Pokemon(response.body!!.id, response.body!!.name, response.body!!.weight)
        }

        return null
    }
}