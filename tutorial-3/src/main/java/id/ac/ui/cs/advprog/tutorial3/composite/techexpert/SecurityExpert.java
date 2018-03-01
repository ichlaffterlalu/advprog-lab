package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class SecurityExpert extends Employees {
    private static final double MINIMUM_SALARY = 70000.00;

    //TODO Implement
    public SecurityExpert(String name, double salary) {
        if (salary < MINIMUM_SALARY) {
            throw new IllegalArgumentException("Salary must be higher than or equals " + MINIMUM_SALARY);
        }

        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
