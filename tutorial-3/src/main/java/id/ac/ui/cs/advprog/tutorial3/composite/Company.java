package id.ac.ui.cs.advprog.tutorial3.composite;

import id.ac.ui.cs.advprog.tutorial3.composite.higherups.Ceo;
import id.ac.ui.cs.advprog.tutorial3.composite.higherups.Cto;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.SecurityExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    protected List<Employees> employeesList;

    public Company() {
        employeesList = new ArrayList<Employees>();
    }

    public Company(List<Employees> employeesList) {
        Collections.copy(this.employeesList, employeesList);
    }

    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Ceo("Jono", 355000));
        company.getAllEmployees().stream().forEach(e -> System.out.print(e.getName() + ", "));
        System.out.println("Net Salaries: " + company.getNetSalaries());

        try {
            company.addEmployee(new Cto("Jojo", 10000));
        } catch (IllegalArgumentException e) {
            System.out.println("Gaji Jojo terlalu kecil");
        }
        company.getAllEmployees().stream().forEach(e -> System.out.print(e.getName() + ", "));
        System.out.println("Net Salaries: " + company.getNetSalaries());

        company.addEmployee(new SecurityExpert("Jeje", 100000));
        company.getAllEmployees().stream().forEach(e -> System.out.print(e.getName() + ", "));
        System.out.println("Net Salaries: " + company.getNetSalaries());
    }

    public void addEmployee(Employees employees) {
        //TODO Implement
        employeesList.add(employees);
    }

    public double getNetSalaries() {
        //TODO Implement
        return employeesList.stream().mapToDouble(e -> e.getSalary()).sum();
    }

    public List<Employees> getAllEmployees() {
        //TODO Implement
        return employeesList;
    }
}