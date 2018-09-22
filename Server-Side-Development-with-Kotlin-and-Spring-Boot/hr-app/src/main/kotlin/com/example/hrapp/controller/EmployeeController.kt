package com.example.hrapp.controller

import com.example.hrapp.model.Employee
import com.example.hrapp.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController {

    @Autowired
    lateinit var employeeService: EmployeeService

    @PostMapping("/employee")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<String> {
        employeeService.createEmployee(employee)
        return ResponseEntity.status(HttpStatus.CREATED).build<String>()
    }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: Int) = employeeService.getEmployee(id)

}
