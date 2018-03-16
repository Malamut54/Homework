package ru.sberbank.homework.bobrov;

import ru.sberbank.homework.common.Calculator;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Improved calculator.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.02.2018
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new CalcImpl();
        while (true) {
            System.out.println(calc.calculate(scanner.nextLine()));
        }
    }
}
