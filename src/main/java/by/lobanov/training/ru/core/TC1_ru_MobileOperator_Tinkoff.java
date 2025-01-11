package by.lobanov.training.ru.core;

import java.util.Arrays;
import java.util.Scanner;

public class TC1_ru_MobileOperator_Tinkoff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputForCalculate = scanner.nextLine();
        int [] arr = Arrays.stream(inputForCalculate.split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(getCostOfService(arr));
    }

    public static int getCostOfService (int [] arr) {
        int aBasePayment = arr[0];
        int bMbGiven = arr[1];
        int cAdditionPayment = arr[2];
        int dWantWaste = arr[3];
        int mbRemain = dWantWaste - bMbGiven;
        if (mbRemain < 0) return aBasePayment;

        int haveToPayInAdditionToBase = mbRemain * cAdditionPayment;
        return haveToPayInAdditionToBase + aBasePayment;
    }
}
