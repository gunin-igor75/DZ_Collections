package pro.sky.dz_collections.service;

import org.springframework.stereotype.Service;
import pro.sky.dz_collections.domain.Employee;
import pro.sky.dz_collections.exeptions.EmployeeAlreadyAddedException;
import pro.sky.dz_collections.exeptions.EmployeeNotFoundException;
import pro.sky.dz_collections.exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private List<Employee> employees = new ArrayList<>();
    {
        loadEmployee();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    // List переполнится если памяти не хватит. Будем считать перпеполнение больше= 15
    public Employee addEmployee(Employee employee) {
        if (employees.size() >= 15) {
            throw new EmployeeStorageIsFullException("Список перепронен");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        if (employee == null || employee.getFirstName() == null || employee.getLastName() == null) {
            return null;
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employee == null || !employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employee == null || !employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public void loadEmployee() {
        Employee employee1 = new Employee("Igor", "Pupkin");
        Employee employee2 = new Employee("Alena", "Sidorova");
        Employee employee3 = new Employee("Max", "Ivanov");
        Employee employee4 = new Employee("Petr", "Petrov");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
    }

    @Override
    public List<Employee> print() {
        return employees;
    }
}
