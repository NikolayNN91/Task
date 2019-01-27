package com.company.Comparator;

import com.company.Driver;

import java.util.Comparator;

public class ComparatorUp implements Comparator<Driver> {
    @Override
    public int compare(Driver o1, Driver o2) {

        int i = (int) (o1.getAverageSalary() - o2.getAverageSalary());
        if(i == 0) {
            i = o1.getName().compareTo(o2.getName());
        }
        return i;
    }
}
