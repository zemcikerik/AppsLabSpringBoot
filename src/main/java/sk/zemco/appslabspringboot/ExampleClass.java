package sk.zemco.appslabspringboot;

import org.springframework.stereotype.Component;
import sk.zemco.appslabspringboot.service.EmployeeService;

@Component
public class ExampleClass {

    public ExampleClass(EmployeeService employeeService) {
        employeeService.writeNumber();
    }

}
