package com.finnetrolle.smlr.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "links")
data class Link(
        var text: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0
)
