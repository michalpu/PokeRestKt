package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.PokeRestApplicationTests
import com.michalpu.PokeRest.config.SpyRestTemplate
import com.michalpu.PokeRest.domain.Pokemon
import org.junit.jupiter.api.Test

class PokemonClientImplTest() : PokeRestApplicationTests() {

    lateinit var pokemonClient: PokemonClientImpl
    lateinit var spyRestTemplate: SpyRestTemplate


    @Test
    fun shouldReturnAPokemon (){

        //given
        spyRestTemplate = SpyRestTemplate()
        pokemonClient = PokemonClientImpl(spyRestTemplate, "https://pokeapi.co/api/v2")

        spyRestTemplate.stubbedGet = """
            {
                "id" : 4,
                "name" : "charmander",
                "weight" : 86
            }
        """.trimIndent()

        //when
        val pokemon = pokemonClient.fetchByName("charmander")

        //then
        assert(pokemon != null)
        assert(pokemon == Pokemon(4, "charmander", 86))
    }


}