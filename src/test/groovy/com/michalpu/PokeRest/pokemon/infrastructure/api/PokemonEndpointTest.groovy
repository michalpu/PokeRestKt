package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import com.michalpu.PokeRest.client.Pokemon
import org.springframework.http.HttpStatus

class PokemonEndpointTest extends BaseIntegrationTest{


    void 'should return status 200 [OK]'(){

        when:
        def pokemonResponse = restTemplate.getForEntity(localUrl("/pokemon/charmander"), Pokemon.class)

        then:
        pokemonResponse.statusCode == HttpStatus.OK
    }

    void 'should return charmander pokemon'(){

        when:
        def pokemon = restTemplate.getForObject(localUrl("/pokemon/charmander"), Pokemon.class)

        then:
        with(pokemon){
            id == 4
            name.equalsIgnoreCase("charmander");
            weight == 85
        }
    }
}
