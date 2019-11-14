package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.domain.Pokemon

interface PokemonClient {
    fun fetchByName(name: String): Pokemon?
}
