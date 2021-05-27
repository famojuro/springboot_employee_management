package com.innovativeapps.employee.data.manager;

import com.innovativeapps.employee.model.Department;

import java.util.List;

public interface DepartmentDataManagerLocal {

    Department get(int id);

    List<Department> getAll();
}
