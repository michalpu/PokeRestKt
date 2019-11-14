package com.michalpu.PokeRest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PokeRestApplication

fun main(args: Array<String>) {
	runApplication<PokeRestApplication>(*args)
}
