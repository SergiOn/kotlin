package com.example.kotlinTest

import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux


fun main (args: Array<String>) {

    println("--Filter---")

//    val fluxInt: Flux<Int> = Flux.fromIterable(arrayListOf(1, 2, 3, 4, 5, 6, 7, 8))
    val fluxInt: Flux<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8).toFlux()

    fluxInt
            .filter { it < 5 }
            .subscribe { println(it) }


    println("--Map---")

    fluxInt
            .map { it * it }
            .subscribe { println(it) }


    println("--Map vs FlatMap---")

    val nameFlux: Flux<Flux<String>> = arrayListOf<Flux<String>>(
            arrayListOf<String>("alberto", "peter").toFlux(),
            arrayListOf<String>("john", "ana").toFlux(),
            arrayListOf<String>("dani", "maria").toFlux()
    ).toFlux()

    nameFlux
            .flatMap { it }
            .subscribe { println(it.capitalize()) }

}
