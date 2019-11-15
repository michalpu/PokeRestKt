package com.michalpu.PokeRest.controller

import com.michalpu.PokeRest.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pokemon")
class PokemonController (@Autowired val pokemonService : PokemonService) {

    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String) =
            pokemonService.getByName(name)
}