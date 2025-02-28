package by.lobanov.training.en.core.codewars;


import by.lobanov.training.util.AssertAndPrintUtil;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Sum all digit to number that is dividing by 3 or 5
 * Example: number -> 6 to digits 1,2,3,4,5,6 -> 3,5 is digits that we search, so find sum of them -> 3 + 5 = 8
 */
public class CW_en_MultiplesThreeOrFive {

    public static void main(String[] args) {
        AssertAndPrintUtil.isEquals(8, solutionWithStream(6));
        AssertAndPrintUtil.isEquals(23, solutionWithStream(10));
    }

    public static int solutionWithStream(int number) {
        IntPredicate isDividedByThreeOrFive = digit -> digit % 3 == 0 || digit % 5 == 0;

        return IntStream.range(0, number)
                .filter(isDividedByThreeOrFive)
                .sum();
    }
}
