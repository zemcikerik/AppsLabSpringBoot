package sk.zemco.appslabspringboot.service;

import org.springframework.stereotype.Service;
import sk.zemco.appslabspringboot.model.Company;
import sk.zemco.appslabspringboot.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company addCompany(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        Iterable<Company> companyIterable = this.companyRepository.findAll();
        List<Company> companyList = new ArrayList<>();

        companyIterable.forEach(companyList::add);
        return companyList;
    }

    @Override
    public Optional<Company> getCompany(long id) {
        return this.companyRepository.findById(id);
    }

}
