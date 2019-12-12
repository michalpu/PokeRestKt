package com.michalpu.PokeRest.pokemon

import com.michalpu.PokeRest.client.Type
import org.springframework.stereotype.Service

@Service
class TypesServiceImpl : TypesService {

    override fun getTypeRelationsForPokemonTypes(types: List<Type>): TypeRelations {

        val typeRelationsBuilder = TypeRelations.Builder()

        for (type in types){
            typeRelationsBuilder
                    .appendNoDamageTo(type.relations.noDamageTo.map { it.name }.toSet())
                    .appendHalfDamageTo(type.relations.halfDamageTo.map { it.name }.toSet())
                    .appendDoubleDamageTo(type.relations.doubleDamageTo.map { it.name }.toSet())
                    .appendNoDamageFrom(type.relations.noDamageFrom.map { it.name }.toSet())
                    .appendHalfDamageFrom(type.relations.halfDamageFrom.map { it.name }.toSet())
                    .appendDoubleDamageFrom(type.relations.doubleDamageFrom.map { it.name }.toSet())

        }

        return typeRelationsBuilder.build()
    }
}