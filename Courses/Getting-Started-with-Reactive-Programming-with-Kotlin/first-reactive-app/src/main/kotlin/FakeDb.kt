
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.rxkotlin.toFlowable

class FakeDb: Db {

    val userMap = mutableMapOf<Int, User>(
            1 to User(1, "Peter"),
            2 to User(2, "Laura"),
            3 to User(3, "John"),
            4 to User(4, "Carl")
    )

    val userPointsMap = mutableMapOf(1 to 40, 2 to 23, 3 to 0, 4 to 5)

//    override fun getAllUser(): Flowable<User> = Flowable.fromIterable(userMap.values)

    override fun getAllUser(): Flowable<User> = userMap.values.toFlowable()

//    override fun getUserById(id: Int): Maybe<User> {
//        return getAllUser()
//                .filter { it.id == id }
//                .firstElement()
//    }

    override fun getUserById(id: Int): Single<User> {
        return getAllUser()
                .filter { it.id == id }
                .firstOrError()
                .onErrorResumeNext { _ -> Single.error(UserNotFound("Id: $id not found on the records")) }
//                .onErrorResumeNext { e -> Single.error(UserNotFound("Id: $id not found on the records")) }
    }

    override fun getPointsForUserId(id: Int): Single<Int> {
        return if (userPointsMap.contains(id))
            Single.just(userPointsMap[id])
        else
            Single.error { UserNotFound("Id: $id is not on the records") }
    }

    override fun addUser(user: User): Completable {
        return Completable.fromAction { userMap[user.id] = user }
    }

//    fun getUsers(): Observable<Map.Entry<Int, User>> {
//        return Observable.fromIterable(userMap.entries)
//    }
//
//    fun getPointsForUser(userId: Int): Observable<Int> {
//        return Observable.just(userPointsMap[userId])
//    }

//    fun getUsers(): Observable<Map.Entry<Int, String>> {
//        return Observable.fromIterable(mapOf<Int, String>(1 to "Peter", 2 to "Laura", 3 to "John", 4 to "Carl").entries)
//    }
//
//    fun getPointsForUser(userId: Int): Observable<Int> {
//        val pointsMap = mapOf<Int, Int>(1 to 40, 2 to 23, 3 to 0, 4 to 5)
//        return Observable.just(pointsMap[userId])
//    }

}

interface Db {
    fun getAllUser(): Flowable<User>
//    fun getUserById(id: Int): Maybe<User>  // Single
    fun getUserById(id: Int): Single<User>  // Single
    fun getPointsForUserId(id: Int): Single<Int>
    fun addUser(user: User): Completable
}

data class User(val id: Int, val name: String)

class UserNotFound(message: String?): Exception(message)
