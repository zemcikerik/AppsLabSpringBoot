package sk.zemco.appslabspringboot.service;

import org.springframework.stereotype.Service;
import sk.zemco.appslabspringboot.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private int number = 0;

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

    @Override
    public void writeNumber() {
        System.out.println(++this.number);
    }

}
