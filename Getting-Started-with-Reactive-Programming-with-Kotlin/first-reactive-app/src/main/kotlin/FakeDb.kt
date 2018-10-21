import io.reactivex.Observable

class FakeDb {

    fun getUsers(): Observable<Map.Entry<Int, String>> {
        return Observable.fromIterable(mapOf<Int, String>(1 to "Peter", 2 to "Laura", 3 to "John", 4 to "Carl").entries)
    }

    fun getPointsForUser(userId: Int): Observable<Int> {
        val pointsMap = mapOf<Int, Int>(1 to 40, 2 to 23, 3 to 0, 4 to 5)
        return Observable.just(pointsMap[userId])
    }

}