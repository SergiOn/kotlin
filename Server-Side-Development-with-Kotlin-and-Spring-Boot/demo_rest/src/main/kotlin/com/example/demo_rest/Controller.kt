package com.example.demo_rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

//    val employeeService: EmployeeService = EmployeeService();

    @Autowired
    lateinit var employeeService: EmployeeService;

    @GetMapping
    fun getName(): String {
        return "Name: Alberto\n";
    }

    @GetMapping("/{name}")
    fun getRealName(@PathVariable("name") name: String): String {
        return "Name: $name\n";
    }

    @GetMapping("/id/{id}")
    fun getNameById(@PathVariable("id") id: Int): String {
        return "${employeeService.findEmployee(id)}\n";
    }
}
