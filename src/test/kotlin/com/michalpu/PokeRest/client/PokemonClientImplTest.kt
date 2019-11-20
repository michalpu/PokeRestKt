package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.PokeRestApplicationTests
import com.michalpu.PokeRest.domain.Pokemon
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class PokemonClientImplTest() : PokeRestApplicationTests() {

    @Autowired
    private lateinit var pokemonClient: PokemonClient

    @Test
    fun shouldReturnAPokemon (){
        //given
        val id = 4L
        val name = "charmander"
        val weight = 86
        stubPokeClient(200, id, name, weight)

        //when
        val pokemon = pokemonClient.fetchByName("charmander")

        //then
        assert(pokemon != null)
        assert(pokemon == Pokemon(4, "charmander", 86))
    }


}