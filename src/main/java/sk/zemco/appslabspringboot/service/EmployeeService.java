package sk.zemco.appslabspringboot.service;

import sk.zemco.appslabspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    float getTotalSalary(List<Employee> employees);
    int getTotalBonus(List<Employee> employees);

}
