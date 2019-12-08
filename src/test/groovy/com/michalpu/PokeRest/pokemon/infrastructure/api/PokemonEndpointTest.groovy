package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import com.michalpu.PokeRest.client.Pokemon
import com.michalpu.PokeRest.client.Type
import org.springframework.http.HttpStatus

class PokemonEndpointTest extends BaseIntegrationTest{

    def setup(){
        stubPokemonClient(200, new Pokemon(4, "charmander", 85))
    }

    void 'should return status 200 [OK] when calling pokemon endpoint'(){
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

    @Override
    boolean equals(Object obj) {
        return super.equals(obj)
    }

    void 'should return types vulnerable to pokemons type'  () {

        when:
        def typeRelations = restTemplate.getForObject(localUrl("/pokemon/charmander/type-relations"),
                                                                TypeRelations.class)
        then:
        with(typeRelations){
            noDamageTo.isEmpty()
            halfDamageTo.contains("water")
            doubleDamageTo.contains("bug")
        }
    }

    void 'should return evolution path'() {
        //pokemon species
        when:
        def evolutionPath = restTemplate.getForObject("/evolutionPath/charmander", EvolutionPath.class)

        then:
        with(evolutionPath){
            evolutions.size == 3
            isBaby == true
            evolutions.get(1).equalsIgnoreCase("charmeleon")
            evolutions.get(2).equalsIgnoreCase("charizard")

        }
    }
}
