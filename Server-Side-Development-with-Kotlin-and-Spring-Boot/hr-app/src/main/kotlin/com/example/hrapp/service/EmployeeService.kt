package com.example.hrapp.service

import com.example.hrapp.model.Employee
import org.springframework.stereotype.Service
//import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class EmployeeService {

    companion object {
        val employeeDb = mutableMapOf<Int, Employee>(
                1 to Employee(1, "John Long", 20, "Engineering", 500.00),
                2 to Employee(2, "Peter Pan", 35, "HR", 300.00)
        )
    }

    fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)

//    fun getEmployee(id: Int) = Mono.from<Employee> { employeeDb[id] }
    fun getEmployee(id: Int) = employeeDb[id]?.toMono()

}
