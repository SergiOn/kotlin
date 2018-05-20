package com.finnetrolle.smlr.model.repositories

import com.finnetrolle.smlr.model.Link
import org.springframework.data.repository.Repository
import java.util.*

//import org.springframework.data.jpa.repository.JpaRepository


//interface LinkRepository : JpaRepository {

interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}
