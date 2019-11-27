package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.client.Pokemon
import com.michalpu.PokeRest.client.PokemonClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pokemon")
class PokemonController (@Autowired val pokemonClient: PokemonClient) {


    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String) : ResponseEntity<Pokemon> {
        val response = pokemonClient.getByName(name)
        return ResponseEntity.ok(response)
    }

}