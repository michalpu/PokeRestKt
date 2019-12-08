package com.michalpu.PokeRest.pokemon

import com.michalpu.PokeRest.client.Type

interface TypesService {

    fun getTypeRelationsFromTypes(types: List<Type>): TypeRelations

}
