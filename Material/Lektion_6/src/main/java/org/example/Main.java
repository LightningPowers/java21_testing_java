package org.example;

import java.util.Scanner;

public class Main {

    public static String name;
    public static String age;
    public static boolean isAdult;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type your first name");
        name = scanner.nextLine();
        System.out.println("Please type your last name");
        name += " " + scanner.nextLine();
        System.out.println(name);
    }

    public static void getUserAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Age: ");
        age = scanner.nextLine();
        try {
            isAdult = Integer.parseInt(age) >= 18;
        }
        catch (NumberFormatException e){
            isAdult = false;
            throw new NumberFormatException();
        }

    }
}