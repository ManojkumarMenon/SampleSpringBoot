package com.manoj.practice.SampleSpringBoot.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.manoj.practice.SampleSpringBoot.entities.Employee;

@Repository
public class EmployeeDao {

    @Autowired
    private MongoOperations ops;

    public List<Employee> get() {
        return ops.findAll(Employee.class);
    }

    public Employee find(String name) {
        return ops.findOne(query(where("name").is(name)), Employee.class);
    }

    public String create(Employee e) {
        ops.insert(e);
        return e.getId();
    }

    public boolean delete(String id) {
        Employee e = ops.findById(id, Employee.class);
        if (e != null) {
            return ops.remove(e).wasAcknowledged();

        }
        return false;
    }

}
