package sk.zemco.appslabspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeJobType.Value.DRIVER)
public class Driver extends Employee {

    public Driver() {
        super(EmployeeJobType.DRIVER);
    }

    public Driver(float salary, int bonus) {
        super(salary, bonus, EmployeeJobType.DRIVER);
    }

}
