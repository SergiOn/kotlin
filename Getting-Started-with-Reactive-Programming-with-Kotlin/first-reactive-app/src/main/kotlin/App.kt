fun main(args: Array<String>) {

    val db: FakeDb = FakeDb()

    db.getUserById(1)
            .subscribe { it -> println(it) }

    db.getUserById(5)
            .subscribe { it -> println(it) }

    db.addUser(User(5, "Jessica"))
            .subscribe { println("User added successfully") }

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
