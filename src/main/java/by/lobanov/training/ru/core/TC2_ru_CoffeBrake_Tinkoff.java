package by.lobanov.training.ru.core;

import java.util.Scanner;

public class TC2_ru_CoffeBrake_Tinkoff {

    public static void main(String[] args) {
        System.out.println(calculateNumberOfCuts(new Scanner(System.in).nextInt()));
    }

    public static int calculateNumberOfCuts (int n) {
        int cuts = (int) Math.ceil((double) 5 /2);
        return cuts;
    }
}


