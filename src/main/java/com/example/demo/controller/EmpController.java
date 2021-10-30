package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;

@RequestMapping("/api/v1")
@RestController
public class EmpController {
	
	private EmpService employeeService;
	
	public EmpController(EmpService employeeService) {
		System.out.println("Heyy...I got an Employee Service Object");
		this.employeeService = employeeService;
	}
	
	@PostMapping("/person")
	public String createEmployee(@RequestBody Employee employee) {
		System.out.println("CreateEmployee");
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/person")
	public List<Employee> getAllEmployees(){
		System.out.println("getAllEmployees");
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/person/{id}")
	public Employee getEmployeeByID(@PathVariable("id") int id) {
		System.out.println("getEmployeeByID");
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/person")
	public String updateEmployee(@RequestBody Employee employee) {
		System.out.println("updateEmployee");
		return employeeService.updateEmployee(employee);
	}
	
	@PutMapping("/person/{id}")
	public String updateEmployee(@PathVariable("id") int id, @RequestBody Map<String,String> employee) {
		System.out.println("updateEmployeeByID"+employee);
		return employeeService.updateEmployeeByID(id,employee);
	}
	
	@DeleteMapping("/person/{id}")
	public String removeEmployeeByID(@PathVariable("id") int id) {
		System.out.println("removeEmployeeByID");
		return employeeService.deleteEmployee(id);
	}
	
	
}
