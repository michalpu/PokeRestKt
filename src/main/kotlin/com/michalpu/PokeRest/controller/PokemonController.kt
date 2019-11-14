package com.michalpu.PokeRest.controller

import com.michalpu.PokeRest.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController (@Autowired val pokemonService : PokemonService) {


}