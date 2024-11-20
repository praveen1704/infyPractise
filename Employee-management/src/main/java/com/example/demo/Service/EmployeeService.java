package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;

@Service
public interface EmployeeService {
	
  Employee addEmployee(Employee employee);
  
  ResponseEntity<?> getEmployee(int id);
  
  List<Employee> getAllEmployees();
  

Employee updateEmployee(Employee employee);
  
  

}
