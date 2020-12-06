package sk.zemco.appslabspringboot.service;

import sk.zemco.appslabspringboot.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company addCompany(Company company);
    List<Company> getAllCompanies();
    Optional<Company> getCompany(long id);
}
