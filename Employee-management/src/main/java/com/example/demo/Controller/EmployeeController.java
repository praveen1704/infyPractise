package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@PostMapping(value = "/addEmployee")
	public ResponseEntity<?> aaddEmployee(@RequestBody Employee employee){
		if(employeeService.getEmployee(employee.getId())!=null ) {
		return	new ResponseEntity<>("Employee with the Id is already present!! ",HttpStatus.BAD_REQUEST);
		}else {

			return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.ACCEPTED);
			}
		
	}
	
	@GetMapping(value="/getEmployeeById")
	public ResponseEntity<?> getEmployeeById(@RequestParam int id) {
		return	employeeService.getEmployee(id);
			
	}
	
	@PutMapping(value = "/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping(value="/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	 
}
