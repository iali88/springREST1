package com.example.RESTdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RESTdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
