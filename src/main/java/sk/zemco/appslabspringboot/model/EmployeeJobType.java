package sk.zemco.appslabspringboot.model;

public enum EmployeeJobType {

    PROGRAMMER("Programmer"),
    TEACHER("Teacher"),
    DRIVER("Driver");

    private final String name;

    EmployeeJobType(String name) {
        this.name = name;

        if (!this.name().equalsIgnoreCase(name)) {
            throw new IllegalStateException();
        }
    }

    public String getName() {
        return name;
    }

    public interface Value {
        String PROGRAMMER = "PROGRAMMER";
        String TEACHER = "TEACHER";
        String DRIVER = "DRIVER";
    }

}
