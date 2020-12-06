package sk.zemco.appslabspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sk.zemco.appslabspringboot.model.Employee;
import sk.zemco.appslabspringboot.service.EmployeeService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Optional<Employee> optionalEmployee = this.employeeService.getEmployeeById(id);
        return ResponseEntity.of(optionalEmployee);
    }

    // TODO: check if this is valid when child classes have their own fields
    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody @NonNull @Valid Employee employee) {
        employee.setId(0);

        Employee savedEmployee = this.employeeService.addEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/totalSalary")
    public float totalSalary() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        return employeeService.getTotalSalary(employees);
    }

    @GetMapping("/totalBonus")
    public int totalBonus() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        return employeeService.getTotalBonus(employees);
    }

}
