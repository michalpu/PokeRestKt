//package com.michalpu.PokeRest.client
//
//import com.michalpu.PokeRest.PokeRestApplicationTests
//import org.junit.jupiter.api.Test
//
//class PokemonClientImplTest() : PokeRestApplicationTests() {
//
//    var spyRestTemplate = SpyRestTemplate()
//    var pokemonClient: PokemonClientImpl = PokemonClientImpl(spyRestTemplate, "https://pokeapi.co/api/v2")
//
//
//    @Test
//    fun shouldReturnAPokemon (){
//
//        //given
//        spyRestTemplate.stubbedGet = """
//            {
//                "id" : 4,
//                "name" : "charmander",
//                "weight" : 86
//            }
//        """.trimIndent()
//
//        //when
//        val pokemon = pokemonClient.getByName("charmander")
//
//        //then
//        assert(pokemon != null)
//        assert(pokemon == Pokemon(4, "charmander", 86))
//    }
//
//
//}