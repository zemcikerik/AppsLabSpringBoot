package sk.zemco.appslabspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import sk.zemco.appslabspringboot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
