package com.michalpu.PokeRest.service

import com.michalpu.PokeRest.domain.Pokemon
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired

@RunWith(MockitoJUnitRunner::class)
class PokemonServiceTest (){

    @Autowired
    lateinit var pokemonService: PokemonService

    @Test
    fun shouldReturnAValidPokemon_WhenCalled(){
        val result = pokemonService.getByName("ditto")
        assert(result != null)
        assert(result == Pokemon(132, "ditto", 40))
    }
}