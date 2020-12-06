package sk.zemco.appslabspringboot.model;

public class Teacher extends Employee {

    public Teacher() {
        super(EmployeeJobType.TEACHER);
    }

    public Teacher(float salary, int bonus) {
        super(salary, bonus, EmployeeJobType.TEACHER);
    }

}
