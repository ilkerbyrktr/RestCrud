package com.ilker.RestCrud.implementation;

import com.ilker.RestCrud.dao.EmployeeDao;
import com.ilker.RestCrud.entity.Employee;
import com.ilker.RestCrud.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findbyId(int id) {
        return employeeDao.findbyId(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        employeeDao.remove(id);
    }
}
