package sk.zemco.appslabspringboot.service;

import sk.zemco.appslabspringboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);

    float getTotalSalary(List<Employee> employees);
    int getTotalBonus(List<Employee> employees);

}
