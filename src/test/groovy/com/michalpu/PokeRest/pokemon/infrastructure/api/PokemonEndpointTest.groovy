package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import com.michalpu.PokeRest.client.Pokemon
import org.springframework.http.HttpStatus

class PokemonEndpointTest extends BaseIntegrationTest {

    def setup() {
        stubPokemonClient(200, new Pokemon(4, "charmander", 85))
    }

    void 'should return status 200 [OK]'() {
        when:
        def pokemonResponse = restTemplate.getForEntity(localUrl("/pokemons/charmander"), Pokemon.class)

        then:
        pokemonResponse.statusCode == HttpStatus.OK
    }

    void 'should return charmander pokemon'() {

        when:
        def pokemon = restTemplate.getForObject(localUrl("/pokemons/charmander"), Pokemon.class)

        then:
        with(pokemon) {
            id == 4
            name.equalsIgnoreCase("charmander")
            weight == 85
        }
    }
}
