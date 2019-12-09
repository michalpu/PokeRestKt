package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.BaseIntegrationTest
import com.michalpu.PokeRest.client.Pokemon
import org.junit.Ignore
import org.springframework.http.HttpStatus
import com.michalpu.PokeRest.pokemon.TypeRelations

class PokemonEndpointTest extends BaseIntegrationTest{

    def setup(){
        stubPokemonResponse(200)
        stubTypeResponse(200)
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
            weight == 86
        }
    }


    void 'should return types vulnerable to pokemons type'  () {

        when:
        def typeRelations = restTemplate.getForObject(localUrl("/pokemon/charmander/type-relations"),
                                                                TypeRelations.class)
        then:
        with(typeRelations){
            noDamageTo.isEmpty()
            noDamageFrom.isEmpty()
            doubleDamageFrom.containsAll(Arrays.asList("ground", "rock", "water"))
            doubleDamageTo.containsAll(Arrays.asList("bug", "steel", "grass", "ice"))
            halfDamageFrom.containsAll(Arrays.asList("bug", "steel", "grass", "ice", "fairy"))
            halfDamageTo.containsAll(Arrays.asList("rock", "water", "fire", "dragon"))
        }
    }

    @Ignore
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
