package com.michalpu.PokeRest.client

interface PokemonClient {
    fun getByName(name: String): Pokemon?
}
