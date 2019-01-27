package com.company.Comparator;

import com.company.Driver;

import java.util.Comparator;

public class ComparatorDown implements Comparator<Driver> {
    @Override
    public int compare(Driver o1, Driver o2) {

        int i = (int) (o2.getAverageSalary() - o1.getAverageSalary());
        if(i == 0) {
            i = o1.getName().compareTo(o2.getName());
        }
        return i;
    }
}
