package com.michalpu.PokeRest.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NamedApiResource(val name: String, val url: String) {
}