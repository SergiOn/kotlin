package com.finnetrolle.smlr.model.repositories

import com.finnetrolle.smlr.model.Link
//import org.springframework.data.repository.CrudRepository
//import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.Repository
import java.util.*



//interface LinkRepository : JpaRepository<Link, Long> {
//interface LinkRepository : CrudRepository<Link, Long> {
interface LinkRepository : Repository<Link, Long> {
//    fun findOne(id: Long?): Optional<Link>
    fun findById(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}
