package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Cto extends Employees {
    public Cto(String name, double salary) {
        //TODO Implement
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        //TODO Implement
        return this.salary;
    }
}
