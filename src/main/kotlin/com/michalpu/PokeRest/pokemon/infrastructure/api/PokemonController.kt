package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.client.Pokemon
import com.michalpu.PokeRest.client.PokemonClient
import com.michalpu.PokeRest.pokemon.TypeRelations
import com.michalpu.PokeRest.pokemon.TypesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemons")
class PokemonController(private val pokemonClient: PokemonClient,
                        private val typesService: TypesService) {


    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String): ResponseEntity<Pokemon> {
        val response = pokemonClient.getPokemonByName(name)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{name}/type-relations")
    fun getTypeRelationsByName(@PathVariable name: String): ResponseEntity<TypeRelations> {
        val pokemon = pokemonClient.getPokemonByName(name)
        val types = pokemonClient.getTypesOfPokemon(pokemon)
        val response = typesService.getTypeRelationsForPokemonTypes(types)

        return ResponseEntity.ok(response)
    }

}