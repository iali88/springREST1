package com.example.RESTdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RESTdemo.dao.EmployeeRepository;
import com.example.RESTdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepo.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("dit not find employee of id = " + id);
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}

}
