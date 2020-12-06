package sk.zemco.appslabspringboot;

import org.springframework.stereotype.Component;
import sk.zemco.appslabspringboot.model.Driver;
import sk.zemco.appslabspringboot.model.Employee;
import sk.zemco.appslabspringboot.model.Programmer;
import sk.zemco.appslabspringboot.model.Teacher;
import sk.zemco.appslabspringboot.service.EmployeeService;

import java.util.List;

@Component
public class DependencyInjectionDemo {

    private final EmployeeService employeeService;

    public DependencyInjectionDemo(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.employeeService.writeNumber();

        List<Employee> employees = createExampleEmployeeList();
        System.out.println(getSum(employees));
    }

    public float getSum(List<Employee> employees) {
        return employeeService.getTotalSalary(employees) + employeeService.getTotalBonus(employees);
    }

    private static List<Employee> createExampleEmployeeList() {
        return List.of(
                new Programmer(1000, 100),
                new Teacher(2000, 200),
                new Driver(3000, 300)
        );
    }

}
