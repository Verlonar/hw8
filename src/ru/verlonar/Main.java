package ru.verlonar;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        split();

        //задание 1
        for (int i = 2010; i < 2023; i++) {
            leapYear(i);
        }

        split();

        //задание 2
        appVersion(0, 2014);
        appVersion(0, 2030);
        appVersion(1, 2012);
        appVersion(1, 2026);
        appVersion(2, 2014);

        split();

        //задание 3
        for (int i = 0; i < 10; i++) {
            int distance = (int) (Math.random() * 150);
            int deliveryTime = deliveryTime(distance);
            if (deliveryTime > 0) {
                System.out.println("На доставки на расстояние " + distance + " потребуется дней: " + deliveryTime);
            } else {
                System.out.println("Доставка на расстояние " + distance + " не осуществляется");
            }
        }

        split();

        //задание 4
        String s = "aabccddefgghiijjkk";
        searchForDuplicates(s);

        s = "abcdefghijk";
        searchForDuplicates(s);

        split();

        //задание 5
        int[] array = {3, 2, 1, 6, 5};
        reverseArray(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        split();

    }

    private static void leapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println(year + " — високосный год");
        } else {
            System.out.println(year + " — не високосный год");
        }
    }

    private static void appVersion(int clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0) {
            if (clientDeviceYear > currentYear) {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            } else {
                System.out.println("Установите версию приложения для iOS по ссылке");
            }
        } else if (clientOS == 1) {
            if (clientDeviceYear > currentYear) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            } else {
                System.out.println("Установите версию приложения для Android по ссылке");
            }
        } else {
            System.out.println("Неопознанная операционная система");
        }
    }

    private static int deliveryTime(int deliveryDistance) {
        byte deliveryDays = 1;

        if (deliveryDistance <= 20) {
            return deliveryDays;
        } else if (deliveryDistance <= 60){
            deliveryDays += 1;
            return deliveryDays;
        } else if (deliveryDistance <= 100) {
            deliveryDays += 2;
            return deliveryDays;
        } else {
            return -1;
        }
    }

    public static void searchForDuplicates(String s) {
        String[] stringsArray = s.split("");
        for (int i = 0; i < stringsArray.length - 1; i++) {
            String desiredChar = stringsArray[i];
            for (int j = i + 1; j < stringsArray.length; j++) {
                String currentChar = stringsArray[j];
                if (desiredChar.equals(currentChar)) {
                    System.out.println("Присутствует дубль - \"" + desiredChar + "\"");
                    return;
                }
            }
        }
        System.out.println("В строке нет дублей");
    }

    public static void reverseArray(int[] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (i == j) return;
            int a = array[i];
            array[i] = array[j];
            array[j] = a;
            j--;
        }
    }

    public static void split() {
        System.out.println("-----------------------------------------------------");
    }
}
