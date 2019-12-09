package com.michalpu.PokeRest.pokemon

class TypeRelations private constructor(val noDamageTo: Set<String>?,
                         val halfDamageTo: Set<String>?,
                         val doubleDamageTo: Set<String>?,
                         val noDamageFrom: Set<String>?,
                         val halfDamageFrom: Set<String>?,
                         val doubleDamageFrom: Set<String>?){

    class Builder (var noDamageTo: MutableSet<String>? = null,
                   var halfDamageTo: MutableSet<String>? = null,
                   var doubleDamageTo: MutableSet<String>? = null,
                   var noDamageFrom: MutableSet<String>? = null,
                   var halfDamageFrom: MutableSet<String>? = null,
                   var doubleDamageFrom: MutableSet<String>? = null){

        fun build() = TypeRelations(noDamageTo, halfDamageTo, doubleDamageTo,
                                    noDamageFrom, halfDamageFrom, doubleDamageFrom)

        fun appendNoDamageTo(types: Set<String>) {
            if(noDamageTo == null){
                noDamageTo = HashSet()
            }
            noDamageTo?.addAll(types)
        }

        fun appendHalfDamageTo(types: Set<String>){
            if(halfDamageTo == null){
                halfDamageTo = HashSet()
            }
            halfDamageTo?.addAll(types)
        }

        fun appendDoubleDamageTo(types: Set<String>){
            if(doubleDamageTo == null){
                doubleDamageTo = HashSet()
            }
            doubleDamageTo?.addAll(types)
        }

        fun appendNoDamageFrom(types: Set<String>){
            if(noDamageFrom == null){
                noDamageFrom = HashSet()
            }
            noDamageFrom?.addAll(types)
        }

        fun appendHalfDamageFrom(types: Set<String>){
            if(halfDamageFrom == null){
                halfDamageFrom = HashSet()
            }
            halfDamageFrom?.addAll(types)
        }

        fun appendDoubleDamageFrom(types: Set<String>){
            if(doubleDamageFrom == null){
                doubleDamageFrom = HashSet()
            }
            doubleDamageFrom?.addAll(types)
        }
    }
}