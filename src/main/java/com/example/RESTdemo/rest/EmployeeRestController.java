package com.example.RESTdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESTdemo.entity.Employee;
import com.example.RESTdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// @Autowired
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getListEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {

		Employee employee = employeeService.findById(id);

		if (employee == null) {
			throw new RuntimeException("Employee not found - " + id);
		}

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {

		// force la création car si valeur == 0 alors création et non update
		employee.setId(0);

		employeeService.save(employee);

		return employee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		employeeService.save(employee);

		return employee;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {

		Employee employee = employeeService.findById(id);

		if (employee == null) {
			throw new RuntimeException("Employee not found - " + id);
		}

		employeeService.deleteById(id);

		return "Delete successfull ( id =  " + id + " )";
	}

}