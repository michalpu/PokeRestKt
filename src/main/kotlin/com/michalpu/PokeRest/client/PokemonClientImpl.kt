package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.domain.Pokemon
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PokemonClientImpl(val pokemonApiRestTemplate: RestTemplate,
                        @Value("\${poke.api.host}") val pokemonApiHostUrl: String): PokemonClient {

    override fun fetchByName(name: String): Pokemon? =
            pokemonApiRestTemplate.getForObject(pokemonApiHostUrl, Pokemon::class.java)
}