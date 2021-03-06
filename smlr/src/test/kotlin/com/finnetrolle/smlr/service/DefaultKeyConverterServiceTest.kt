package com.finnetrolle.smlr.service

import org.junit.Test
import java.util.Random


class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertibleBothWays() {
        val rand = Random()
        for (i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)

            org.junit.Assert.assertEquals(initialId, id)
        }
    }

}
