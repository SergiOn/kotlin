package com.example.hrapp.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
class CassandraConfig: AbstractCassandraConfiguration() {

    override fun getKeyspaceName(): String  = "hr"

    override fun getContactPoints(): String = "localhost"
//        return super.getContactPoints()

    override fun getEntityBasePackages(): Array<String> = arrayOf("com.example.hrapp.model")

}
