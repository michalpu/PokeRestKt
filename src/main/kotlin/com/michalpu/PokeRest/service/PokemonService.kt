package com.michalpu.PokeRest.service

import com.michalpu.PokeRest.domain.Pokemon

interface PokemonService {
    fun getByName(name: String) : Pokemon?
}
