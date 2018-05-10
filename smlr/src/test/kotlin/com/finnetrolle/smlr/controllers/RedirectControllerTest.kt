package com.finnetrolle.smlr.controllers

import com.finnetrolle.smlr.SmlrApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(SmlrApplication::class))
@WebAppConfiguration
class RedirectControllerTest {

    @Autowired lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()
    }

    private val PATH = "/aAbBcCdD"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME = "Location"
    private val HEADER_VALUE = "http://www.eveonline.com"

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
//        mockMvc.perform(MockMvcRequestBuilders.get(PATH))
//                .andExpect(MockMvcResultMatchers.status())
        mockMvc.perform(get(PATH))
                .andExpect(status().`is`(REDIRECT_STATUS))
                .andExpect(header().string(HEADER_NAME, HEADER_VALUE))
    }


    private val BAD_PATH = "/olololo"
    private val NOT_FOUND: Int = 404

    @Test
    fun controllerMustReturn404IfBadKey() {
        mockMvc.perform(get(BAD_PATH))
                .andExpect(status().`is`(NOT_FOUND))
    }

}
