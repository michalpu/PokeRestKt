package com.michalpu.PokeRest.client

class PokemonClientException(cause: Throwable) : RuntimeException("Pokemon client exception", cause)