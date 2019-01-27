package com.company;

import com.company.Comparator.ComparatorDown;
import com.company.Comparator.ComparatorUp;

import java.io.*;
import java.util.*;

public class FileRW {

    ComparatorUp comparatorUp = new ComparatorUp();
    ComparatorDown comparatorDown = new ComparatorDown();

    Set<Driver> driversList = null;

    public Set<Driver> fileRead(String fileName, boolean bool) {

        if(bool) {
            driversList = new TreeSet<>(comparatorDown);
        } else {
            driversList = new TreeSet<>(comparatorUp);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("resource/" + fileName)))) {

            String line = null;

            while((line = reader.readLine()) != null) {

                String[] string = line.split("=");
                Double pay = Double.parseDouble(string[1]);
                Driver driver = new Driver(string[0], pay);
                driversList.add(driver);

            }

        } catch (FileNotFoundException e) {
        //e.printStackTrace();
        System.out.println("Такого файла не существует, попробуйте снова:\n ");
        return null;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода-вывода, обратитесь к администратору!\n ");

        }
        return driversList;
    }

    public void fileWrite(String fileName, Set<Driver> driversList) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("resource/" + fileName)))) {

            for(Driver driver : driversList) {
                String lineSeparator = System.getProperty("line.separator");
                writer.write(driver.getName() + "=" + driver.getAverageSalary() + lineSeparator);
            }
            System.out.println("Список сохранен в файле " + fileName);

            } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
