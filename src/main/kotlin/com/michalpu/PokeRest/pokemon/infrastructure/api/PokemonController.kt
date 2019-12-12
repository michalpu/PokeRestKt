package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.client.Pokemon
import com.michalpu.PokeRest.client.PokemonClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemons")
class PokemonController(private val pokemonClient: PokemonClient) {


    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String): ResponseEntity<Pokemon> {
        val response = pokemonClient.getByName(name)
        return ResponseEntity.ok(response)
    }

}