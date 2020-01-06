package com.michalpu.PokeRest.pokemon

class TypeRelations private constructor(val noDamageTo: Set<String>?,
                                        val halfDamageTo: Set<String>?,
                                        val doubleDamageTo: Set<String>?,
                                        val noDamageFrom: Set<String>?,
                                        val halfDamageFrom: Set<String>?,
                                        val doubleDamageFrom: Set<String>?) {

    class Builder(var noDamageTo: MutableSet<String>? = null,
                  var halfDamageTo: MutableSet<String>? = null,
                  var doubleDamageTo: MutableSet<String>? = null,
                  var noDamageFrom: MutableSet<String>? = null,
                  var halfDamageFrom: MutableSet<String>? = null,
                  var doubleDamageFrom: MutableSet<String>? = null) {

        fun build() = TypeRelations(noDamageTo, halfDamageTo, doubleDamageTo,
                noDamageFrom, halfDamageFrom, doubleDamageFrom)

        fun appendNoDamageTo(types: Set<String>): Builder {
            if (noDamageTo == null) {
                noDamageTo = HashSet()
            }
            noDamageTo?.addAll(types)
            return this
        }

        fun appendHalfDamageTo(types: Set<String>): Builder {
            if (halfDamageTo == null) {
                halfDamageTo = HashSet()
            }
            halfDamageTo?.addAll(types)
            return this
        }

        fun appendDoubleDamageTo(types: Set<String>): Builder {
            if (doubleDamageTo == null) {
                doubleDamageTo = HashSet()
            }
            doubleDamageTo?.addAll(types)
            return this
        }

        fun appendNoDamageFrom(types: Set<String>): Builder {
            if (noDamageFrom == null) {
                noDamageFrom = HashSet()
            }
            noDamageFrom?.addAll(types)
            return this
        }

        fun appendHalfDamageFrom(types: Set<String>) : Builder {
            if (halfDamageFrom == null) {
                halfDamageFrom = HashSet()
            }
            halfDamageFrom?.addAll(types)
            return this
        }

        fun appendDoubleDamageFrom(types: Set<String>) : Builder {
            if (doubleDamageFrom == null) {
                doubleDamageFrom = HashSet()
            }
            doubleDamageFrom?.addAll(types)
            return this
        }
    }
}