package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import org.springframework.http.HttpStatus

class PokemonEndpointTest extends BaseIntegrationTest{

    void 'should return status 200 [OK]'(){
        when:
        def pokemonResponse = restTemplate.getForEntity(localUrl("/pokemon/1000"))

        then:
        pokemonResponse.statusCode == HttpStatus.OK
    }
}
