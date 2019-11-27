package com.michalpu.PokeRest.pokemon.infrastructure.api

import com.michalpu.PokeRest.PokeRestApplicationTests
import com.michalpu.PokeRest.client.Pokemon
import junit.framework.Assert.assertNotNull
import org.junit.Ignore
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemonEndpointIntegrationTest : PokeRestApplicationTests() {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun whenCalledProperly_shouldReturnPokemonn(){
        //given
        stubPokeClient(200, 25, "pikachu", 60)

        //when
        val result = testRestTemplate.getForEntity("http://localhost:8080/pokemon/pikachu", Pokemon::class.java)

        //then
        assertNotNull(result)
        assert(result?.statusCode == HttpStatus.OK)
        assert(result?.body == Pokemon(25, "pikachu", 60))
    }

    @Ignore
    @Test
    fun WhenCalledWithNonExistingName_shouldReturnStatusNotFound(){
        val result = testRestTemplate.getForEntity("http://localhost:8080/pokemon/non_existing", Pokemon::class.java)

        assertNotNull(result)
        assert(result?.statusCode == HttpStatus.NOT_FOUND)

    }

}