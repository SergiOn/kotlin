package com.finnetrolle.smlr.service

import org.junit.Assert.*
import org.junit.Test


class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "aAbBcCdD"
    private val LINK_A: String = "http://google.com"
    private val LINK_B: String = "http://yahoo.com"

    @Test
    fun clientCanAddLinks() {
        val keyA = service.add(LINK_A)
        assertEquals(KeyMapperService.Get.Link(LINK_A), service.getLink(keyA))
        val keyB = service.add(LINK_B)
        assertEquals(KeyMapperService.Get.Link(LINK_B), service.getLink(keyB))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }


//    @Test
//    fun clientCanAddNewKeyWithLink() {
////        org.junit.Assert.assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
//        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
//        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
//    }


//    @Test
//    fun clientCanNotAddExistingKey() {
//        service.add(KEY, LINK)
////        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK))
//        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
//        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
//    }

}
