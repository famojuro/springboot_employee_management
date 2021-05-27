package com.innovativeapps.employee.data.manager;

import com.innovativeapps.employee.data.provider.DataProviderLocal;
import com.innovativeapps.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDataManager implements EmployeeDataManagerLocal{

    @Autowired
    DataProviderLocal crud;

    @Override
    public Employee create(Employee employee) { return crud.create(employee);}

    @Override
    public Employee get(String id) { return crud.find(id, Employee.class); }

    @Override
    public List<Employee> getAll() { return crud.findAll(Employee.class); }

    @Override
    public Employee update(Employee employee) { return crud.update(employee); }

    @Override
    public void delete(Employee employee) { crud.delete(employee); }

}
