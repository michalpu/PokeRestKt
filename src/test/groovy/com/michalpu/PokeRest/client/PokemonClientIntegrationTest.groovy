package com.michalpu.PokeRest.client

import com.michalpu.PokeRest.BaseIntegrationTest
import org.springframework.beans.factory.annotation.Autowired

class PokemonClientIntegrationTest extends BaseIntegrationTest {

    @Autowired
    PokemonClient pokeClient

    def 'should return modified charmander'() {
        given:
        stubPokemonResponse(200)

        when:
        Pokemon pokemon = pokeClient.getPokemonByName("charmander")

        then:
        with(pokemon) {
            id == 4
            name.equalsIgnoreCase("charmander")
            weight == 86
        }
    }

    def 'should return fire type'() {
        given:
        stubTypeResponse(200)

        when:
        Type type = pokeClient.getTypeByName("fire")

        then:
        with(type) {
            name.equalsIgnoreCase("fire")
            id == 10
        }

    }

    def 'should return fire type for charmander'() {
        given:
        stubPokemonResponse(200)
        stubTypeResponse(200)
        Pokemon charmander = pokeClient.getPokemonByName("charmander")

        when:
        List<Type> types = pokeClient.getTypesOfPokemon(charmander)

        then:
        with(types) {
            size == 1
            get(0).name.equalsIgnoreCase("fire")
            get(0).id == 10
        }
    }
}
