package com.michalpu.PokeRest.client

interface PokemonClient {

    fun getPokemonByName(name: String): Pokemon

    fun getTypeByName(name: String): Type

}
