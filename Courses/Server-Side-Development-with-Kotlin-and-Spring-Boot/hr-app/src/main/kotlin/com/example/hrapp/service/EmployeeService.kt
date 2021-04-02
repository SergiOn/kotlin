package com.example.hrapp.service

//import reactor.core.publisher.Mono
import com.example.hrapp.model.EmployeeDTO
import com.example.hrapp.model.EmployeeUpdateReg
import com.example.hrapp.repository.EmployeeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService {

    @Autowired
    lateinit var employeeDb: EmployeeRepo

    fun createEmployee(employeeDTO: EmployeeDTO) = employeeDb.save(EmployeeDTO.newEmployee(employeeDTO))

    fun getEmployee(id: String) = employeeDb.findById(id)

    fun getAllEmployees(minAge: Int? = null, minSalary: Double? = null)
            = employeeDb.findAll()
                .filter { it.age >= minAge ?: Int.MIN_VALUE }
                .filter { it.salary >= minSalary ?: Double.MIN_VALUE }

    fun updateEmployee(id: String, updateEmployee: EmployeeUpdateReg) =
            employeeDb.findById(id)
                .flatMap {
                    it.department = updateEmployee.department ?: it.department
                    it.salary = updateEmployee.salary ?: it.salary
                    employeeDb.save(it)
                }

    fun deleteEmployee(id: String) = employeeDb.deleteById(id)


//    companion object {
//        val employeeDb = mutableMapOf<Int, Employee>(
//                1 to Employee(1, "John Long", 20, "Engineering", 500.00),
//                2 to Employee(2, "Peter Pan", 35, "HR", 300.00)
//        )
//    }
//
//    fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)
//
//    //    fun getEmployee(id: Int) = Mono.from<Employee> { employeeDb[id] }
//    fun getEmployee(id: Int) = employeeDb[id]?.toMono()
//
//    fun getAllEmployees(minAge: Int? = null, minSalary: Double? = null) = employeeDb.values.toFlux()
//            .filter { it.age >= minAge ?: Int.MIN_VALUE }
//            .filter { it.salary >= minSalary ?: Double.MIN_VALUE }
//
//    fun updateEmployee(id: Int, updateEmployee: EmployeeUpdateReg) {
//        val employeeOnDb = employeeDb[id]!!
//        employeeDb[id] = Employee(
//                employeeOnDb.id,
//                employeeOnDb.name,
//                employeeOnDb.age,
//                updateEmployee.department ?: employeeOnDb.department,
//                updateEmployee.salary ?: employeeOnDb.salary
//        )
//    }
//
//    fun deleteEmployee(id: Int) = employeeDb.remove(id)

}
