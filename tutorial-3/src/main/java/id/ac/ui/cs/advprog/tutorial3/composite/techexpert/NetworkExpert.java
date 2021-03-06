package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class NetworkExpert extends Employees {
    private static final double MINIMUM_SALARY = 50000.00;

    //TODO Implement
    public NetworkExpert(String name, double salary) {
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
        return "Network Expert";
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
