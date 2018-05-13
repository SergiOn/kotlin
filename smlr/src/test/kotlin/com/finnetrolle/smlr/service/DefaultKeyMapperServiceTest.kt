package com.finnetrolle.smlr.service

import org.junit.Assert.*
import org.junit.Test


class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "aAbBcCdD"
    private val LINK: String = "http://www.eveonline.com"
    private val LINK_NEW: String = "http://wow.ru"

    @Test
    fun clientCanAddNewKeyWithLink() {
//        org.junit.Assert.assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }


    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)
//        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }

}
