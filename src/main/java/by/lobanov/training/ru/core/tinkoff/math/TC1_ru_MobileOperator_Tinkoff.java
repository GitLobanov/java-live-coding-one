package by.lobanov.training.ru.core.tinkoff.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Костя подключен к мобильному оператору «Мобайл». Абонентская плата Кости составляет  рублей в месяц.
 * За эту стоимость Костя получает мегабайт интернет-трафика. Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему  рублей.
 * Костя планирует потратить мегабайт интернет-трафика в следующий месяц. Помогите ему сосчитать, во сколько рублей ему обойдется интернет.
 * <br>
 * Формат входных данных <br>
 * Вводится 4 целых положительных числа A, B, C, D - стоимость тарифа Кости, размер тарифа Кости, стоимость каждого лишнего мегабайта,
 * размер интернет-трафика Кости в следующем месяце. Числа во входном файле разделены пробелами.
 * Формат выходных данных <br>
 * Выведите одно натуральное число — суммарные расходы Кости на интернет.
 * <br>
 * Пример 1
 * in: 100 10 12 15
 * out: 160
 * <br>
 * Пример 2
 * in: 100 10 12 1
 * out: 100
 */
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
