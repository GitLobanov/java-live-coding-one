package by.lobanov.training.ru.core.tinkoff.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Пример 1
 * Input
 * n t 5  5 количество сотрудников и время, когда один из сотрудников покинет офис (в минутах)
 * employees 1  4  9  16  25 номера этажей, на которых находятся сотрудники
 * s(t) 2 номер сотрудника, который уйдет через t минут.
 * Output
 * 24 - количество пролетов нужно пройти
 */
public class TC3_ru_FlightsOfStairs_Tinkoff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] employees = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = sc.nextInt();

        int res = calculateNumberOfStairs(nt, employees, n);
        System.out.println(res);
    }

    public static int calculateNumberOfStairs(int[] nt, int[] employees, int numberOfEmployeeWhoFirstGoOff) {
        int timeWhenFirstEmployeeGoOff = nt[1];
        int floorOfEmployeeThatFirstGoOff = employees[numberOfEmployeeWhoFirstGoOff - 1];
        int floorWhereKatya = 0;
        int floorsThatKatyaGoThought = 0;
        if (timeWhenFirstEmployeeGoOff <= floorOfEmployeeThatFirstGoOff) {
            floorWhereKatya = floorOfEmployeeThatFirstGoOff;
            employees[numberOfEmployeeWhoFirstGoOff - 1] = 0;
        } else {
            floorWhereKatya = employees[0];
            employees[0] = 0;
        }

        for (int employee : employees) {
            if (employee != 0) {
                if (floorWhereKatya > employee) {
                    floorsThatKatyaGoThought = floorsThatKatyaGoThought + (floorWhereKatya - employee);
                    floorWhereKatya = employee;
                } else {
                    floorsThatKatyaGoThought = floorsThatKatyaGoThought + (employee - floorWhereKatya);
                    floorWhereKatya = employee;
                }
            }
        }
        return floorsThatKatyaGoThought;
    }
}
