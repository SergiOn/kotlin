package com.finnetrolle.smlr.service

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap


@Component
class DefaultKeyMapperService: KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()


    override fun add(key: String, link: String): KeyMapperService.Add {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLink(key: String): KeyMapperService.Add {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
