package com.example.hrapp.model

data class Employee(
        val id: Int,
        val name: String,
        val age: Int,
        var department: String,
        var salary: Double
)

data class EmployeeUpdateReg(
        val department: String?,
        val salary: Double?
)
