package com.michalpu.PokeRest.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Pokemon(
        val id: Long,
        val name: String,
        val weight: Int)