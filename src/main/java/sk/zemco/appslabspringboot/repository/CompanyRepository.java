package sk.zemco.appslabspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import sk.zemco.appslabspringboot.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
