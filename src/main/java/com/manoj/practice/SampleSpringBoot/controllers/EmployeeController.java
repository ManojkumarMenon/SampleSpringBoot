package com.manoj.practice.SampleSpringBoot.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.practice.SampleSpringBoot.entities.Employee;
import com.manoj.practice.SampleSpringBoot.service.EmployeeService;

@RestController
public class EmployeeController {

    private static final Log LOG = LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployees() {
        LOG.info("GET API call for get all employee...");
        return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("name") String name) {
        return new ResponseEntity<>(service.getEmployee(name), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
        LOG.info("DELETE API call for deleting employee id:- " + id);
        return service.deleteEmployee(id) ? new ResponseEntity<>("Employee deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Employee deletion unsuccessfully.", HttpStatus.NOT_IMPLEMENTED);

    }

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEmployee(@RequestBody Employee e) {
        LOG.info("POST API call for creating employee:- " + e);
        service.createEmployee(e);
        return new ResponseEntity<>("Employee created successfully with id:-" + e.getId(), HttpStatus.OK);
    }
}
