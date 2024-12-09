package by.lobanov.training.december.demo2;

public class Lc2 {

    public static void main(String[] args) {
        // Напишите программу, чтобы найти второе по величине число в массиве
        int[] numbersArray = {10, 15, 32, 100, -99, 11, 98, 36, 95, 33, 100};

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > max1) {
                max2 = max1;
                max1 = numbersArray[i];
            } else if (numbersArray[i] > max2 && numbersArray[i] < max1) {
                max2 = numbersArray[i];
            }
        }

        System.out.println(max2);
    }

}
