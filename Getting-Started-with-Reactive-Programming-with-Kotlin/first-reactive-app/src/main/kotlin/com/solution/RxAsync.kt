package com.solution

import io.reactivex.rxkotlin.toFlowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {

    println("--- subscribe ---")

    listOf<String>("Alberto", "Peter", "Lara", "James").toFlowable()
            .subscribe { println("Item $it was received on thread ${Thread.currentThread().name}") }

//    println("--- Schedulers.newThread ---")
//
//    listOf<String>("Alberto", "Peter", "Lara", "James").toFlowable()
//            .doOnNext { println("Item $it was created on thread ${Thread.currentThread().name}") }
//            .subscribeOn(Schedulers.newThread())
//            .subscribe { println("Item $it was received on thread ${Thread.currentThread().name}") }
//
//    Thread.sleep(100)

    println("--- Schedulers.newThread with blockingSubscribe ---")

    listOf<String>("Alberto", "Peter", "Lara", "James").toFlowable()
            .doOnNext { println("Item $it was created on thread ${Thread.currentThread().name}") }
            .subscribeOn(Schedulers.newThread())
            .blockingSubscribe { println("Item $it was received on thread ${Thread.currentThread().name}") }

    println("--- observeOn ---")

    var postFix: Int = 0

    listOf<String>("Alberto", "Peter", "Lara", "James").toFlowable()
            .doOnNext { println("Item $it was created on thread ${Thread.currentThread().name}") }
            .observeOn(Schedulers.newThread())
            .map { "$it-${postFix++}" }
            .doOnNext { println("Map operator was done on thread ${Thread.currentThread().name}") }
            .subscribeOn(Schedulers.newThread())
            .blockingSubscribe { println("Item $it was received on thread ${Thread.currentThread().name}") }

}
