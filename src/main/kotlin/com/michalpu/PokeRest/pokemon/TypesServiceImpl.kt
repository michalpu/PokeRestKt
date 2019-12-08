package com.michalpu.PokeRest.pokemon

import com.michalpu.PokeRest.client.Type

class TypesServiceImpl() : TypesService {

    override fun getTypeRelationsFromTypes(types: List<Type>): TypeRelations {
        var noDamageTo: MutableSet<String> = HashSet()
        var halfDamageTo: MutableSet<String> = HashSet()
        var doubleDamageTo: MutableSet<String> = HashSet()
        var noDamageFrom: MutableSet<String> = HashSet()
        var halfDamageFrom: MutableSet<String> = HashSet()
        var doubleDamageFrom: MutableSet<String> = HashSet()

        for (type in types){
            noDamageTo.addAll(type.typeRelations.noDamageTo.map { it.name })
            halfDamageTo.addAll(type.typeRelations.halfDamageTo.map { it.name })
            doubleDamageTo.addAll(type.typeRelations)
        }
    }
}