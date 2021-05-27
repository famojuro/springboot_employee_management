package com.innovativeapps.employee.data.manager;

import com.innovativeapps.employee.model.Employee;

import java.util.List;

public interface EmployeeDataManagerLocal {

    Employee create(Employee employee);

    Employee get(String id);

    List<Employee> getAll();

    Employee update(Employee employee);

    void delete(Employee employee);
}
