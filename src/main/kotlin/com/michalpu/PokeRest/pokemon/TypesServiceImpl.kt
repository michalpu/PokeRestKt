package com.michalpu.PokeRest.pokemon

import com.michalpu.PokeRest.client.Type
import org.springframework.stereotype.Service

@Service
class TypesServiceImpl : TypesService {

    override fun getTypeRelationsForPokemonTypes(types: List<Type>): TypeRelations {

        val typeRelationsBuilder = TypeRelations.Builder()

        for (type in types){
            typeRelationsBuilder.appendNoDamageTo(type.relations.noDamageTo.map { it.name }.toSet())
            typeRelationsBuilder.appendHalfDamageTo(type.relations.halfDamageTo.map { it.name }.toSet())
            typeRelationsBuilder.appendDoubleDamageTo(type.relations.doubleDamageTo.map { it.name }.toSet())
            typeRelationsBuilder.appendNoDamageFrom(type.relations.noDamageFrom.map { it.name }.toSet())
            typeRelationsBuilder.appendHalfDamageFrom(type.relations.halfDamageFrom.map { it.name }.toSet())
            typeRelationsBuilder.appendDoubleDamageFrom(type.relations.doubleDamageFrom.map { it.name }.toSet())

        }

        return typeRelationsBuilder.build()
    }
}