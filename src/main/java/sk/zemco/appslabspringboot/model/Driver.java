package sk.zemco.appslabspringboot.model;

public class Driver extends Employee {

    public Driver() {
        super(EmployeeJobType.DRIVER);
    }

    public Driver(float salary, int bonus) {
        super(salary, bonus, EmployeeJobType.DRIVER);
    }

}
