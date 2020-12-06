package sk.zemco.appslabspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(EmployeeJobType.Value.TEACHER)
public class Teacher extends Employee {

    public Teacher() {
        super(EmployeeJobType.TEACHER);
    }

    public Teacher(float salary, int bonus) {
        super(salary, bonus, EmployeeJobType.TEACHER);
    }

}
