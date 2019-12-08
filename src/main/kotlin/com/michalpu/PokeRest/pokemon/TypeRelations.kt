package com.michalpu.PokeRest.pokemon

class TypeRelations private constructor(val noDamageTo: Set<String>,
                         val halfDamageTo: Set<String>?,
                         val doubleDamageTo: Set<String?>,
                         val noDamageFrom: Set<String>?,
                         val halfDamageFrom: Set<String>?,
                         val doubleDamageFrom: Set<String>?){
    data class Builder
}