package sk.zemco.appslabspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.zemco.appslabspringboot.model.Driver;
import sk.zemco.appslabspringboot.model.Employee;
import sk.zemco.appslabspringboot.model.Programmer;
import sk.zemco.appslabspringboot.model.Teacher;

import java.util.List;

@SpringBootApplication
public class AppsLabSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsLabSpringBootApplication.class, args);
    }

    public static List<Employee> createExampleEmployeeList() {
        return List.of(
                new Programmer(1000, 100),
                new Teacher(2000, 200),
                new Driver(3000, 300)
        );
    }

}
