package com.michalpu.PokeRest.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Pokemon (val id: Long, val name: String, val weight: Int)