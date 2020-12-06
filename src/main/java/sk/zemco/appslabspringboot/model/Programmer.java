package sk.zemco.appslabspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeJobType.Value.PROGRAMMER)
public class Programmer extends Employee {

    public Programmer() {
        super(EmployeeJobType.PROGRAMMER);
    }

    public Programmer(float salary, int bonus) {
        super(salary, bonus, EmployeeJobType.PROGRAMMER);
    }

    @Override
    public String getInfo() {
        return String.format("Programmer's salary is %.1f.", salary + bonus);
    }

}
