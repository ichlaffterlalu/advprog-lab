package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Cto extends Employees {
    private static final double MINIMUM_SALARY = 100000.00;

    public Cto(String name, double salary) {
        //TODO Implement
        if (salary < MINIMUM_SALARY) {
            throw new IllegalArgumentException("Salary must not below" + MINIMUM_SALARY);
        }

        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return "CTO";
    }

    @Override
    public double getSalary() {
        //TODO Implement
        return this.salary;
    }
}
