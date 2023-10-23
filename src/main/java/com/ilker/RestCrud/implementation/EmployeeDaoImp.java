package com.ilker.RestCrud.implementation;

import com.ilker.RestCrud.dao.EmployeeDao;
import com.ilker.RestCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findbyId(int id) {
        return entityManager.find(Employee.class,id);
    }


    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void remove(Integer id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
