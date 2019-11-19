package com.michalpu.PokeRest.integration

import com.michalpu.PokeRest.domain.Pokemon
import junit.framework.Assert.assertNotNull
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemonEndpointIntegrationTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun whenCalledProperly_shouldReturnPokemonn(){
        val result = testRestTemplate.getForEntity("http://localhost:8080/pokemon/charmander", Pokemon::class.java)

        assertNotNull(result)
        assert(result?.statusCode == HttpStatus.OK)
        assert(result?.body == Pokemon(4, "charmander", 85))
    }

    @Ignore
    @Test
    fun WhenCalledWithNonExistingName_shouldReturnStatusNotFound(){
        val result = testRestTemplate.getForEntity("http://localhost:8080/pokemon/non_existing", Pokemon::class.java)

        assertNotNull(result)
        assert(result?.statusCode == HttpStatus.NOT_FOUND)

    }

}