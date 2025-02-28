package by.lobanov.training.en.core.codewars;

import by.lobanov.training.util.AssertAndPrintUtil;

/**
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 *
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
 * Example:
 * Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
 * # returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
 */
public class CW_en_RangeExtraction {

    public static void main(String[] args) {
        AssertAndPrintUtil.isEqualsAndPrint("-6,-3-1,3-5,7-11,14,15,17-20", rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        AssertAndPrintUtil.isEqualsAndPrint("-3--1,2,10,15,16,18-20", rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
    }

    public static String rangeExtraction(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int start = arr[i];
            result.append(start);

            int j = i + 1;
            while (j < n && arr[j] == arr[j - 1] + 1) {
                j++;
            }

            if (j - i >= 3) {
                result.append('-').append(arr[j - 1]).append(',');
                i = j - 1;
            } else {
                if (i < n - 1) {
                    result.append(',');
                }
            }
        }

        // Удаляем последнюю запятую, если она есть
        if (!result.isEmpty() && result.charAt(result.length() - 1) == ',') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}

