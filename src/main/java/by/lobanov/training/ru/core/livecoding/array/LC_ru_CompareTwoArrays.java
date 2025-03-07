package by.lobanov.training.ru.core.livecoding.array;

/**
 * Сравнить два массива
 */
public class LC_ru_CompareTwoArrays {

    public static void main(String[] args) {
        System.out.println(compare(new int[]{1,2,3}, new int[]{1,2,3}));
        System.out.println(compare(new int[]{3,2,1}, new int[]{1,2,3}));
        System.out.println(compare(new int[]{3,2}, new int[]{1,2,3}));
    }

    public static boolean compare (int [] arr1, int [] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
