package sk.zemco.appslabspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeJobType.Value.TEACHER)
public class Teacher extends Employee {

    public Teacher() {
        super(EmployeeJobType.TEACHER);
    }

    public Teacher(Company company, float salary, int bonus, EmployeeJobType type) {
        super(company, salary, bonus, EmployeeJobType.TEACHER);
    }

    public Teacher(long companyId, float salary, int bonus, EmployeeJobType type) {
        super(companyId, salary, bonus, EmployeeJobType.TEACHER);
    }

}
