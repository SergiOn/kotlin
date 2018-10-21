import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {

    val db: FakeDb = FakeDb()

    // Get all users's names
    db.getUsers()
            .map { user -> user.value }
            .subscribe({ println(it) })
//            .subscribe({ name -> println(name) })

    // Get all users's names
    db.getUsers()
            .flatMap { user -> db.getPointsForUser(user.key).zipWith(Observable.just(user.value), {
                points, username -> "$username has $points points"
            }) }
            .subscribe({ println(it) })


}
