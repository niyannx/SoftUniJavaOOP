package EncapsulationLab.SalaryIncrease;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            this.salary = this.salary + (this.salary * bonus / 200);
        } else {
            this.salary = this.salary + (this.salary * bonus /100);
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        df.setMinimumFractionDigits(1);

        return String.format("%s %s gets %s leva", this.firstName, this.lastName, df.format(this.salary));
    }
}
