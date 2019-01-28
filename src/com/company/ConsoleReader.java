package com.company;

import java.util.Scanner;

public class ConsoleReader {

    DriversService driversService = new DriversService();

    String fileName = null;

    public void consoleRead(String consoleLine, Scanner scanner) {

        switch (consoleLine) {
            case "loading":
                System.out.println("Введите имя файла, с которым вы хотите работать, в формете 'name.txt': ");
                fileName = scanner.nextLine();
                System.out.println("Сортировать по возрастанию/убыванию заработной платы: U/D ");
                String sort = scanner.nextLine();
                boolean bool = false;
                switch (sort) {
                    case "U":
                        break;
                    case "D":
                        bool = true;
                        break;
                }
                driversService.getDriversList(fileName, bool);
                if (driversService.getList() != null) {
                    System.out.println("Загрузка файла выполнена успешно\n");
                }
                break;

            case "print":
                if (driversService.getList() != null) {
                    driversService.printDrivers();
                } else {
                    System.out.println("Список пуст, либо не инициализирован\n");
                }

                break;

            case "save":
                if (driversService != null) {
                    System.out.println("Введите название файла в формате 'name.txt':");
                    String stringSave = scanner.nextLine();
                    driversService.saveList(stringSave);
                }
                break;

            case "add":
                System.out.println("Введите ФИО в формате 'Фамилия Имя Отчество':");
                String name = scanner.nextLine();

                System.out.println("Ввести фиксированную месячную оплату: 'salary'\n"
                        + "Ввести почасовую ставку: 'rate'\n");
                String strConsole = scanner.nextLine();
                switch (strConsole) {
                    case "salary":
                        System.out.println("Введите среднемесячный заработок водителя в формате: '0.0'");
                        double salary = scanner.nextDouble();
                        driversService.addDriver(name, salary);
                        break;
                    case "rate":
                        System.out.println("Введите почасовую ставку: '0.0'");
                        double rate = scanner.nextDouble();
                        driversService.addDriverByRate(name, rate);
                    default:
                        System.out.println("Неверная команда, попробуйте снова");
                }
                break;

            case "remove":
                System.out.println("Введите номер водителя в списке, которого необходимо удалить:");
                int number = scanner.nextInt();
                scanner.nextLine();
                driversService.removeDriverByNumber(number);
                break;

            case "printN":
                if (driversService.getList() != null) {
                    System.out.println("Введите число водителей:");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    driversService.printNDrivers(n);
                } else {
                    System.out.println("Список пуст, либо не инициализирован");
                }
                break;

            case "exit":
                break;

            default:
                System.out.println("Неверная команда, попробуйте снова:");
                break;

        }
    }
}
