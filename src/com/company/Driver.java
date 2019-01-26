package com.company;

public class Driver implements Comparable<Driver>{

    private String name;
    private double averageSalary;


    public Driver(String name, double averageSalary) {
        this.name = name;
        this.averageSalary = averageSalary;
    }

    public Driver(String name) {
        this.name = name;
        averageSalary = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public void calculateSalary(double rate) {
        averageSalary = 20.8 * 8 * rate;
    }

    @Override
    public int compareTo(Driver driver) {

        int i = (int) (this.averageSalary - driver.averageSalary);
        if(i == 0) {
            i = this.name.compareTo(driver.name);
        }
        return i;
    }

    @Override
    public String toString() {
        return name + "\t- Среднемесячный заработок: " + averageSalary + "р.";
    }
}
