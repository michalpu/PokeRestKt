package com.michalpu.PokeRest.service

import com.michalpu.PokeRest.client.PokemonClient
import com.michalpu.PokeRest.domain.Pokemon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PokemonServiceImpl(@Autowired val pokemonClient: PokemonClient) : PokemonService{

    override fun getByName(name: String): Pokemon {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}