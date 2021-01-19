package sk.zemco.appslabspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sk.zemco.appslabspringboot.model.Company;
import sk.zemco.appslabspringboot.service.CompanyService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return this.companyService.getAllCompanies();
    }


    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id) {
        Optional<Company> optionalCompany = this.companyService.getCompany(id);
        return ResponseEntity.of(optionalCompany);
    }

    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody @NonNull @Valid Company company) {
        company.setId(0);
        Company addedCompany = this.companyService.addCompany(company);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedCompany.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
