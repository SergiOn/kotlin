package com.example.hrapp.service

import com.example.hrapp.model.Employee
import org.springframework.stereotype.Service
import reactor.core.publisher.toFlux
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

    fun getAllEmployees(minAge: Int? = null, minSalary: Double? = null) = employeeDb.values.toFlux()
                    .filter { it.age >= minAge ?: Int.MIN_VALUE }
                    .filter { it.salary >= minSalary ?: Double.MIN_VALUE }

}
