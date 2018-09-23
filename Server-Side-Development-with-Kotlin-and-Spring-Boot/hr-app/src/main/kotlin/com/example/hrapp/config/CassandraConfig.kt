package com.example.hrapp.config

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration

class CassandraConfig: AbstractCassandraConfiguration() {

    override fun getKeyspaceName(): String  = "hr"

    override fun getContactPoints(): String = "localhost"
//        return super.getContactPoints()

    override fun getEntityBasePackages(): Array<String> = arrayOf("com.example.hrapp.model")

}
