package com.example.hrapp.service

import com.example.hrapp.model.Employee
import org.springframework.stereotype.Service

@Service
class EmployeeService {

    companion object {
        val employeeDb = mutableMapOf<Int, Employee>(
                1 to Employee(1, "John Long", "Engineering", 500.00),
                2 to Employee(2, "Peter Pan", "HR", 300.00)
        )
    }

    fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)

}
