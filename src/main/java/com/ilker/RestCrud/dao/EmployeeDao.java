package com.ilker.RestCrud.dao;

import com.ilker.RestCrud.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee findbyId(int id);
    Employee save(Employee employee);
    void remove(Integer id);
}
