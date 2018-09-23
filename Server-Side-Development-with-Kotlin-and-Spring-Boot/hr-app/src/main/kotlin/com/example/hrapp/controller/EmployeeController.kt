package com.example.hrapp.controller

import com.example.hrapp.model.Employee
import com.example.hrapp.model.EmployeeDTO
import com.example.hrapp.model.EmployeeUpdateReg
import com.example.hrapp.service.DepartmentService
import com.example.hrapp.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
class EmployeeController {

    @Autowired
    lateinit var employeeService: EmployeeService

    @Autowired
    lateinit var departmentService: DepartmentService

//    @PostMapping("/employee")
//    fun createEmployee(@RequestBody employee: Employee): Mono<ResponseEntity<String>> = employeeService.createEmployee(employee)
//            .map { _ -> ResponseEntity.status(HttpStatus.CREATED).build<String>() }

//    @PostMapping("/employee")
//    fun createEmployee(@RequestBody employee: Employee): Mono<ResponseEntity<Employee>> = employeeService.createEmployee(employee)
//            .map { newEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(newEmployee) }

    @PostMapping("/employee")
    fun createEmployee(@Valid @RequestBody employee: EmployeeDTO): Mono<ResponseEntity<Employee>> = employeeService.createEmployee(employee)
            .map { newEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(newEmployee) }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: String) = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAge", required = false) minAge: Int?,
                     @RequestParam("minSalary", required = false) minSalary: Double?) =
            employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments() = departmentService.getAllDepartments()

    @PutMapping("/employee/{id}")
    fun updateEmployee(@PathVariable id: String,
                       @RequestBody updateEmployee: EmployeeUpdateReg) =
            employeeService.updateEmployee(id, updateEmployee)
                    .map { _ -> ResponseEntity.ok() }
//                    .map { _ -> ResponseEntity.status(HttpStatus.OK).build<String>() }

//    @DeleteMapping("/employee/{id}")
//    fun deleteEmployee(@PathVariable id: Int): Mono<ResponseEntity<String>> = employeeService.deleteEmployee(id)
//            .map { _ -> ResponseEntity.status(HttpStatus.NOT_FOUND).build<String>() }

    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable id: String): Mono<ResponseEntity.HeadersBuilder<*>> = employeeService.deleteEmployee(id)
            .map { _ -> ResponseEntity.noContent() }

}
