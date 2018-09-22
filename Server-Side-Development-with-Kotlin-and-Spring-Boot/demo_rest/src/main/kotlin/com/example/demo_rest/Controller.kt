package com.example.demo_rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping
    fun getName(): String {
        return "Name: Alberto\n";
    }

    @GetMapping("/{name}")
    fun getRealName(@PathVariable("name") name: String): String {
        return "Name: $name\n";
    }
}
