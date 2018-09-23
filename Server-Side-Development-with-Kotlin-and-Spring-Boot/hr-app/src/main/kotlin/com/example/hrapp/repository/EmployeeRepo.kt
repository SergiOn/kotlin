package com.example.hrapp.repository

import com.example.hrapp.model.Employee
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository

interface EmployeeRepo: ReactiveCassandraRepository<Int, Employee>
