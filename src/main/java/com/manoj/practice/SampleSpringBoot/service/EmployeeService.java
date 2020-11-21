package com.manoj.practice.SampleSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.practice.SampleSpringBoot.dao.EmployeeDao;
import com.manoj.practice.SampleSpringBoot.entities.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees() {
        return employeeDao.get();
    }

    public Employee getEmployee(String name) {
        return employeeDao.find(name);
    }

    public String createEmployee(Employee e) {
        return employeeDao.create(e);
    }

    public boolean deleteEmployee(String id) {
        return employeeDao.delete(id);
    }

}
