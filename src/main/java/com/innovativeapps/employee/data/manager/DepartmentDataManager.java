package com.innovativeapps.employee.data.manager;

import com.innovativeapps.employee.data.provider.DataProviderLocal;
import com.innovativeapps.employee.model.Department;
import com.innovativeapps.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentDataManager implements DepartmentDataManagerLocal{
    @Autowired
    DataProviderLocal crud;

    @Override
    public Department get(int id) { return crud.find(id, Department.class); }

    @Override
    public List<Department> getAll() { return crud.findAll(Department.class); }
}
