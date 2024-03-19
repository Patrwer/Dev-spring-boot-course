package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // defining fields for entitymanager

    private EntityManager entityManager;

    // setting up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // creating a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // executing query and getting result list
        List<Employee> employees = theQuery.getResultList();

        // returning results

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // getting employee

        Employee theEmployee = entityManager.find(Employee.class, theId);

        // returning employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // saving employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // returning dbEmployee

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        // finding employee id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);


    }
}
