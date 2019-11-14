package com.michalpu.PokeRest.controller

import com.michalpu.PokeRest.domain.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "Pokemon") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, ${name}")
}