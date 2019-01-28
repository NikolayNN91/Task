package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsoleReader consoleReader = new ConsoleReader();
        boolean exit = false;
        String consoleLine;
        Scanner scanner = new Scanner(System.in);

        while (!exit){
            System.out.println("\nЗагрузить список водителей из файла:\t 'loading'\n"
                    + "Вывести полный список водителей на экран:\t 'print'\n"
                    + "Вывести N-e количество водителей на экран:\t 'printN'\n"
                    + "Удалить водителя по номеру на экране:\t 'remove'\n"
                    + "Добавить водителя в список:\t 'add'\n"
                    + "Сохранить список водителей в файл:\t 'save'\n"
                    + "Закрыть программу:\t 'exit'");


            consoleLine = scanner.nextLine();
            if(consoleLine.compareTo("exit")==0) exit = true;

            consoleReader.consoleRead(consoleLine, scanner);
        }

    }
}
