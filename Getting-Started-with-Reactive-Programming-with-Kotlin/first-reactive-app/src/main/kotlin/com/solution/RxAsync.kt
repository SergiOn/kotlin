package com.solution

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable

fun main(args: Array<String>) {

    /*
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

*/

    println("--- stream: Error ---")

//    listOf<String>("Alberto", "Peter", "Lara", "Carl", "James").stream()
//            .forEach {
//                if (it == "Carl")
//                    throw (IllegalArgumentException("Invalid"))
//                else
//                    println(it)
//            }

    listOf("Alberto", "Peter", "Lara", "Carl", "James").stream()
            .forEach {
                try {
                    if (it == "Carl")
                        throw (IllegalArgumentException("Invalid"))
                    else
                        println(it)
                } catch (e: IllegalArgumentException) {
                    println("We had an exception")
                }
            }

    println("--- toFlowable: Error ---")

    listOf("Alberto", "Peter", "Lara", "Carl", "James").toFlowable()
            .doOnNext {
                if (it == "Carl")
                    throw (IllegalArgumentException("Invalid"))
//                else
//                    it
            }
            .subscribeBy(
                    onNext = {
                        println(it)
                    },
                    onError = {
                        println("We had an exception")
                    },
                    onComplete = {
                        println("Stream is complete")
                    }
            )

    println("--- toFlowable: Complete ---")

    listOf("Alberto", "Peter", "Lara", "Carl", "James").toFlowable()
            .subscribeBy(
                    onNext = {
                        println(it)
                    },
                    onError = {
                        println("We had an exception")
                    },
                    onComplete = {
                        println("Stream is complete")
                    }
            )

}
