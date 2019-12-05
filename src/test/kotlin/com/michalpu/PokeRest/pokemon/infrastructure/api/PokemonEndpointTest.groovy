package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import com.michalpu.PokeRest.client.Pokemon
import org.springframework.http.HttpStatus

class PokemonEndpointTest extends BaseIntegrationTest{


    void 'should return status 200 [OK]'(){
        given:
        stubPokemonClient(200)

        when:
        def pokemonResponse = restTemplate.getForEntity(localUrl("/pokemon/1000"))

        then:
        pokemonResponse.statusCode == HttpStatus.OK
    }

    void 'should return charmander pokemon'(){
        given:
        stubPokemonClient(200)

        when:
        def pokemon = restTemplate.getForObject(localUrl("/pokemon/1000"), Pokemon.class)

        then:
        with(pokemon){
            id = 1000
            name.equalsIgnoreCase("Charmander");
            weight == 99
        }
    }
}
