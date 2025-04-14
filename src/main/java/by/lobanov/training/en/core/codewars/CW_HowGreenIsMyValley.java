package by.lobanov.training.en.core.codewars;

import java.util.Arrays;
import java.util.Comparator;

/*
Input : an array of integers.
Output : this array, but sorted in such a way that there are two wings:
the left wing with numbers decreasing,
the right wing with numbers increasing.
the two wings have the same length. If the length of the array is odd the wings are around the bottom,
if the length is even the bottom is considered to be part of the right wing.
each integer l of the left wing must be greater or equal to its counterpart r in the right wing,
the difference l - r being as small as possible. In other words the right wing must be nearly as steep as the left wing.
 */
public class CW_HowGreenIsMyValley {

    public static void main(String[] args) {
        int[] a = new int[] { 17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1 };
        int[] r = new int[] { 17, 15, 8, 7, 4, 1, 4, 5, 7, 14, 17 };
        System.out.println(Arrays.equals(r, (makeValley(a))));
    }

    public static int[] makeValley(int[] arr) {
        int [] newArr = new int[arr.length];
        int i = 0;
        int left = 0;
        int right = arr.length - 1;

        int[] reversed = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        while (left <= right) {
           if (i % 2 != 0) {
               newArr[right] = reversed[i];
               right--;
           } else {
               newArr[left] = reversed[i];
               left++;
           }

           i++;
        }

        return newArr;
    }
}
