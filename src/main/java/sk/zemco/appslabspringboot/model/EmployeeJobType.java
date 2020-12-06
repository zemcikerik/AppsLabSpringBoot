package sk.zemco.appslabspringboot.model;

public enum EmployeeJobType {

    PROGRAMMER("Programmer"),
    TEACHER("Teacher"),
    DRIVER("Driver");

    private final String name;

    EmployeeJobType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
