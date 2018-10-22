import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {

    val db: FakeDb = FakeDb()

    db.getUserById(1)
            .subscribe { it -> println(it) }

//    db.getUserById(5)
//            .subscribe { it -> println(it) }

//    db.addUser(User(5, "Jessica"))
//            .subscribe { println("User added successfully") }

    println("--- map ---")

    db.getAllUser()
            .map { it.name }
            .subscribe { println(it) }

    println("--- flatMap ---")

    db.getAllUser()
            .flatMapSingle { db.getPointsForUserId(it.id) }
            .subscribe { println(it) }

    println("--- filter ---")

    db.getAllUser()
            .flatMapSingle { db.getPointsForUserId(it.id) }
            .filter { it > 10 }
            .subscribe { println(it) }

    println("--- zip ---")

    db.getAllUser()
            .flatMapSingle { Single.zip(Single.just(it), db.getPointsForUserId(it.id),
                    BiFunction {
                        user: User, points: Int -> "${user.name} has $points!"
                    })
            }
            .subscribe { println(it) }

    println("--- zipWith: zip kotlin ---")

    db.getAllUser()
            .flatMapSingle { Single.just(it).zipWith(db.getPointsForUserId(it.id), { user: User, points: Int -> "${user.name} has $points!" }) }
            .subscribe { println(it) }


//    // Get all users's names
//    db.getUsers()
//            .map { user -> user.value }
//            .subscribe({ println(it) })
////            .subscribe({ name -> println(name) })
//
//    // Get all users's names
//    db.getUsers()
//            .flatMap { user -> db.getPointsForUser(user.key).zipWith(Observable.just(user.value), {
//                points, username -> "$username has $points points"
//            }) }
//            .subscribe({ println(it) })


}
