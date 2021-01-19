package sk.zemco.appslabspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeJobType.Value.DRIVER)
public class Driver extends Employee {

    public Driver() {
        super(EmployeeJobType.DRIVER);
    }

    public Driver(Company company, float salary, int bonus) {
        super(company, salary, bonus, EmployeeJobType.DRIVER);
    }

    public Driver(long companyId, float salary, int bonus) {
        super(companyId, salary, bonus, EmployeeJobType.DRIVER);
    }

}
