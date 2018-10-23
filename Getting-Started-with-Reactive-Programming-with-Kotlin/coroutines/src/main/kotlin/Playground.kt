
import io.reactivex.rxkotlin.blockingSubscribeBy
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.rx2.rxFlowable

fun main(args: Array<String>) {

    // Blocking
//    println("Start blocking code...")
//
//    Thread.sleep(1000L)
//
//    println("Stop blocking code...")

//    launch {
//
//        println("Start non-blocking code...")
//
//        delay(1000L)
//
//        println("Stop non-blocking code...")
//
//    }
//
//    Thread.sleep(1500L)

//    runBlocking {
//
//        println("Start non-blocking code...")
//
//        delay(1000L)
//
//        println("Stop non-blocking code...")
//
//    }

    // Faster

//    var x = 0
//
////    val job = List(1_000_000) {
////        thread(start = true) {
////            x++
////        }
////    }
//
//    val job = List(1_000_000) {
//        runBlocking {
//            x++
//        }
//    }

    // Cheaper

//    val job = List(1_000_000) {
//        thread(start = true) {
//            Thread.sleep(10000L)
//        }
//    }
//
//    job.forEach { it.join() }
    // out of memory

//    runBlocking {
//        val job = List(1_000_000) {
//            launch {
//                delay(1000L)
//            }
//        }
//
//        job.forEach { it.join() }
//    }



//    listOf("Alberto", "Peter", "John").toFlowable()
//            .map {
//                it.toUpperCase()
//            }
//            .blockingSubscribeBy(
//                    onNext = {
//                        println(it)
//                    }
//            )

    rxFlowable {

        delay(100L)

        listOf("Alberto", "Peter", "John")
                .forEach { send(it) }

    }.map {
        it.toUpperCase()
    }
    .blockingSubscribeBy(
            onNext = {
                println(it)
            }
    )


}