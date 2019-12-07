package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.BaseIntegrationTest
import org.springframework.beans.factory.annotation.Autowired

class PokemonClientIntegrationTest extends BaseIntegrationTest{

    @Autowired
    PokemonClient pokeClient

    def 'should return modified charmander'(){
        given:
        stubPokemonClient(200, new Pokemon(1000, "charmander", 100))

        when:
        Pokemon pokemon = pokeClient.getByName("charmander")

        then:
        with(pokemon){
            id == 1000
            name.equalsIgnoreCase("charmander")
            weight == 100
        }
    }
}
