package by.lobanov.training.en.core.codewars;

import java.util.stream.IntStream;

/*
Given a square matrix (i.e. an array of subarrays), find the sum of values from the first value of the first array,
the second value of the second array, the third value of the third array, and so on...

 array = [[5, 9, 1, 0],
         [8, 7, 2, 3],
         [1, 4, 1, 9],
         [2, 3, 8, 2]]

diagonal sum: 5 + 7 + 1 + 2 = 15
 */
public class CW_FindSumOfTopLeftToBottomRightDiagonals {

    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{
                {1, 2},
                {3, 4}
        }));

        System.out.println(diagonalSum(new int[][]{
                {5, 9, 1, 0},
                {8, 7, 2, 3},
                {1, 4, 1, 9},
                {2, 3, 8, 2}
        }));
    }

    public static int diagonalSum(final int[][] matrix) {
        return IntStream.range(0, matrix[0].length)
                .map(i -> matrix[i][i])
                .sum();
    }
}
