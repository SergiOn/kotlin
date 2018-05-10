package com.finnetrolle.smlr.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping("/{key}")
class RedirectController {

    @RequestMapping
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse) {
        response.setHeader("Location", "http://www.eveonline.com");
        response.status = 302
    }
}