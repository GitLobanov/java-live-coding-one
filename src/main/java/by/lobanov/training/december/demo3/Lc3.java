package by.lobanov.training.december.demo3;

import java.util.stream.IntStream;

public class Lc3 {

    public static void main(String[] args) {
        System.out.println(equalSidesOfAnArray(new int[]{20,10,-80,10,10,15,35}));
    }

    // {1,2,3,4,3,2,1} = 3
    // {1,100,50,-51,1,1} = 1
    // {20,10,-80,10,10,15,35} = 0


        private static int equalSidesOfAnArray(int[] arr) {

            return IntStream.range(0, arr.length)
                    .filter(i -> IntStream.of(arr).limit(i).sum() == IntStream.of(arr).skip(i+1).sum())
                    .findAny()
                    .orElse(-1);

        }

    //    private static int equalSidesOfAnArray(int[] arr) {
//
//        for (int i = 0; i < arr.length; i++) {
//            int sumRight = 0;
//            int sumLeft = 0;
//
//            for (int j = i; j >= 0; j--) {
//                sumLeft = sumLeft + arr[j];
//            }
//
//            for (int j = i; j < arr.length; j++) {
//                sumRight = sumRight + arr[j];
//            }
//
//            if (sumRight == sumLeft) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

}
