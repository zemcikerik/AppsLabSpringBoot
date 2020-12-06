package sk.zemco.appslabspringboot.service;

import org.springframework.stereotype.Service;
import sk.zemco.appslabspringboot.model.Employee;
import sk.zemco.appslabspringboot.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Iterable<Employee> employeeIterable = this.employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();

        employeeIterable.forEach(employeeList::add);
        return employeeList;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public float getTotalSalary(List<Employee> employees) {
        return (float) employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public int getTotalBonus(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getBonus)
                .sum();
    }

}
