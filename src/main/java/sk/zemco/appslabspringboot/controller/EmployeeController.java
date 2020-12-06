package sk.zemco.appslabspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.zemco.appslabspringboot.AppsLabSpringBootApplication;
import sk.zemco.appslabspringboot.model.Employee;
import sk.zemco.appslabspringboot.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/totalSalary")
    public float totalSalary() {
        List<Employee> employees = AppsLabSpringBootApplication.createExampleEmployeeList();
        return employeeService.getTotalSalary(employees);
    }

    @GetMapping("/totalBonus")
    public int totalBonus() {
        List<Employee> employees = AppsLabSpringBootApplication.createExampleEmployeeList();
        return employeeService.getTotalBonus(employees);
    }

    @GetMapping("/snailDistance")
    public static double snailDistance(
            @RequestParam double stepHeight,
            @RequestParam double stepLength,
            @RequestParam double towerHeight
    ) {
        double stepCount = towerHeight / stepHeight;
        return stepCount * stepLength + towerHeight;
    }

}
