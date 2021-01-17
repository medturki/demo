package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeList;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	@GetMapping(value = "/msg/{user}", produces = "application/json")
	public ResponseEntity<String> getMsg(@PathVariable String user) {
		return  new ResponseEntity<String>("hello " + user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/employees")
    public EmployeeList getAllEmployees()
    {
        EmployeeList employees = new EmployeeList();
          
        Employee emp1 = new Employee(1,"med","turki","medturki@gmail.com");
        Employee emp2 = new Employee(2,"noura","smichi","nourasmichi@gmail.com");
        Employee emp3 = new Employee(3,"hello","world","hellworld@gmail.com");
          
          
        employees.getEmployees().add(emp1);
        employees.getEmployees().add(emp2);
        employees.getEmployees().add(emp3);
          
        return employees;
    }
      
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            Employee employee = new Employee(1,"med","turki","medturki@gmail.com");
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }

}
