package com.company;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DriversService {

    FileRW fileRW = new FileRW();
    private Set<Driver> driversList = new TreeSet<>();


    //загружаем список водителей из файла
    public Set<Driver> getDriversList(String fileName, boolean bool) {

        driversList = fileRW.fileRead(fileName, bool);
        return driversList;

    }

    //распечатываем список водителей
    public void printDrivers() {
        int i = 1;
        for(Driver driver : driversList) {
            System.out.println(i + ": " + driver.toString());
            i++;
        }

    }

    //распечатываем N-е количество водителей из списка
    public void printNDrivers(int n) {
        Iterator<Driver> iterator = driversList.iterator();
        int count = 0;
        while(iterator.hasNext() && (count < n)) {
                System.out.println(iterator.next().toString());
                count++;

        }

    }

    //сохранить список в файл
    public void saveList(String fileName) {

        fileRW.fileWrite(fileName, driversList);

    }

    //удаление водителя по номеру в списке
    public void removeDriverByNumber(int n) {
        int count = 0;
        Driver remove = null;
        Iterator<Driver> iterator = driversList.iterator();

       do {
           remove = iterator.next();
           count++;
       } while (iterator.hasNext() && (count != n));

        driversList.remove(remove);
        printDrivers();
        System.out.println("Водитель удален из списка");
    }


    //добавить водителя в список по имени и месячной зарплате
    public void addDriver(String name, double salary) {

        Driver driver = new Driver(name, salary);
        driversList.add(driver);

    }

    //добавить водителя в список по имени и почасовой ставке
    public void addDriverByRate(String name, double rate) {

        Driver driver = new Driver(name);
        driver.calculateSalary(rate);
        driversList.add(driver);

    }

    //вернуть лист с водителями
    public Set<Driver> getList() {
        return driversList;
    }

}
