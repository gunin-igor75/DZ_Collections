package pro.sky.dz_collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dz_collections.domain.Employee;
import pro.sky.dz_collections.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                 @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employee = employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping("/remove")
    Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                    @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employee = employeeService.removeEmployee(employee);
        return employee;
    }

    @GetMapping("/find")
    Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                  @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employee = employeeService.findEmployee(employee);
        return employee;
    }

    @GetMapping("/print")
    List<Employee> print() {
        return employeeService.print();
    }
}
