package ru.sberbank.homework.bobrov;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Improved calculator.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.02.2018
 */


public class Input {
    private CalcImpl calc = new CalcImpl();
    private Scanner sc = new Scanner(System.in);

    public void inputProcessing() {
        String answer = null;
        try {
            answer = calc.calculate(sc.nextLine());
            System.out.println(answer);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            String tmp = sc.nextLine();
            if (tmp.length() < 5) {
                try {
                    answer = calc.calculate(String.format("%s %s", answer.toString(), tmp));
                    System.out.println(answer);

                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    answer = calc.calculate(tmp);
                    System.out.println(answer);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


    }

}
