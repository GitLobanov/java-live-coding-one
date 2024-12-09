package by.lobanov.training.december.demo3;

import java.util.List;
import java.util.stream.IntStream;

public class Lc5 {

    //(2, 4, 0, 100, 4, 11, 2602, 36)
    //Вывод: 11 (единственное нечетное число)

    //(160, 3, 1719, 19, 11, 13, -21)
    //Вывод: 160 (единственное четное число)

    public static void main(String[] args) {
        System.out.println(findTheParityOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

    private static int findTheParityOutlier(int[] array) {

        List<Integer> evenList = IntStream.of(array)
                .filter(digit -> digit % 2 == 0).boxed()
                .toList();

        List<Integer> oddList = IntStream.of(array)
                .filter(digit -> digit % 2 != 0).boxed()
                .toList();

        return evenList.size() == 1 ? evenList.get(0) : oddList.get(0);

//        List<Integer> evenList = new ArrayList<>();
//        List<Integer> oddList = new ArrayList<>();
//
//        for (int i = 0; i< array.length;i++) {
//
//            if (array[i] % 2 == 0) {
//                evenList.add(array[i]);
//            } else {
//                oddList.add(array[i]);
//            }
//
//        }
//
//        if (evenList.size() == 1) {
//            return evenList.get(0);
//        } else {
//            return oddList.get(0);
//        }

    }

}
