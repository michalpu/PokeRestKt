package com.michalpu.PokeRest.pokemon

import com.michalpu.PokeRest.client.Type

interface TypesService {

    fun getTypeRelationsForPokemonTypes(types: List<Type>): TypeRelations

}
