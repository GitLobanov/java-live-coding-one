package by.lobanov.training.ru.livecoding.core.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Инвертировать входящий массив
 * {1, 2, 3, 4, 5}
 */
public class LC_ArrayReverse {

    public static void main(String[] args) {
        LC_ArrayReverse lc = new LC_ArrayReverse();
        System.out.println(Arrays.toString(lc.arrayReverseClassic(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(lc.arrayReversePointers(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(lc.arrayReverseStack(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(lc.arrayReverseRecursive(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(lc.arrayReverseCollectionReverse(new int[]{1,2,3,4,5})));
    }

    // 1 way
    public int[] arrayReverseClassic(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    // 2 way
    public int[] arrayReversePointers(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    // 3 way
    public int[] arrayReverseStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int num : array) {
            stack.push(num);
        }
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = stack.pop();
        }
        return reversed;
    }

    // 4 way
    public int[] arrayReverseRecursive(int[] array) {
        return reverseHelper(array, 0, array.length - 1);
    }

    private int[] reverseHelper(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        return reverseHelper(array, start + 1, end - 1);
    }

    // 5 way
    public int[] arrayReverseCollectionReverse(int[] array) {
        List<Integer> list = Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new));
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
