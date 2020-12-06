package sk.zemco.appslabspringboot.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Driver.class, name = EmployeeJobType.Value.DRIVER),
        @JsonSubTypes.Type(value = Programmer.class, name = EmployeeJobType.Value.PROGRAMMER),
        @JsonSubTypes.Type(value = Teacher.class, name = EmployeeJobType.Value.TEACHER)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Min(0)
    protected float salary;

    @Min(0)
    protected int bonus;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    protected EmployeeJobType type;

    protected Employee() {
    }

    protected Employee(EmployeeJobType type) {
        this.type = type;
    }

    protected Employee(float salary, int bonus, EmployeeJobType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    public String getInfo() {
        return String.format("%s's salary is %.1f and bonus is %d.", type.getName(), salary, bonus);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public EmployeeJobType getType() {
        return type;
    }

    protected void setType(EmployeeJobType type) {
        this.type = type;
    }

}
