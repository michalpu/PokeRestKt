package com.michalpu.PokeRest.controller

import com.michalpu.PokeRest.domain.Pokemon
import com.michalpu.PokeRest.service.PokemonService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PokemonControllerTest {

    @InjectMocks
    lateinit var pokemonController: PokemonController

    @Mock
    lateinit var pokemonService: PokemonService

    @Test
    fun shouldReturnDittoPokemon_whenCalled() {
        val result = pokemonController.getByName("ditto")
        assert(result != null)
        assert(Pokemon(132, "ditto", 40) == result)
    }

}