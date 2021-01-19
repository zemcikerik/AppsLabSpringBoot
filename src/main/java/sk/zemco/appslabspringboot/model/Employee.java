package sk.zemco.appslabspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
    protected Company company;

    @Column(name = "company_id")
    private long companyId;

    @Positive
    protected float salary;

    @PositiveOrZero
    protected int bonus;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    protected EmployeeJobType type;

    protected Employee() {
    }

    protected Employee(EmployeeJobType type) {
        this.type = type;
    }

    protected Employee(Company company, float salary, int bonus, EmployeeJobType type) {
        this(company.getId(), salary, bonus, type);
        this.company = company;
    }

    protected Employee(long companyId, float salary, int bonus, EmployeeJobType type) {
        this.companyId = companyId;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getCompanyId() {
        return companyId;
    }

    protected void setCompanyId(long companyId) {
        this.companyId = companyId;
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
