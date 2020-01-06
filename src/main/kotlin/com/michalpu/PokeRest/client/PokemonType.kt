package com.michalpu.PokeRest.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonType (val slot: Int, val type : NamedApiResource)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Type (val id: Int, val name: String,
                 @JsonProperty("damage_relations") val relations: TypeRelations)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TypeRelations(@JsonProperty("no_damage_to") val noDamageTo: List<NamedApiResource>,
                         @JsonProperty("half_damage_to") val halfDamageTo: List<NamedApiResource>,
                         @JsonProperty("double_damage_to") val doubleDamageTo: List<NamedApiResource>,
                         @JsonProperty("no_damage_from") val noDamageFrom: List<NamedApiResource>,
                         @JsonProperty("half_damage_from") val halfDamageFrom: List<NamedApiResource>,
                         @JsonProperty("double_damage_from") val doubleDamageFrom: List<NamedApiResource>){
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class NamedApiResource(val name: String, val url: String)