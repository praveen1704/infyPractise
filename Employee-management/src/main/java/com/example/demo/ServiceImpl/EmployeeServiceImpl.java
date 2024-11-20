package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<?> getEmployee(int id) {
		Optional<Employee> employee=employeeRepository.findById(id);
			if(employee.isPresent()) 
			       return new ResponseEntity<>(employee,HttpStatus.OK);
		     else 
					return new ResponseEntity<>("Employee for the given id is not present",HttpStatus.BAD_REQUEST);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee oldemployeedetails = employeeRepository.findById(employee.getId()).get();
		oldemployeedetails.setDepartment(employee.getDepartment());
		oldemployeedetails.setSalary(employee.getSalary());
		oldemployeedetails.setName(employee.getName());
		Employee updatedEmployee=employeeRepository.save(oldemployeedetails);
		
		return updatedEmployee;
	}

}
