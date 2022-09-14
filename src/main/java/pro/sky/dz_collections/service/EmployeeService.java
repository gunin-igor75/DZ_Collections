package pro.sky.dz_collections.service;

import pro.sky.dz_collections.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee removeEmployee(Employee employee);
    Employee findEmployee(Employee employee);
    void loadEmployee();
    List<Employee> print();
}
