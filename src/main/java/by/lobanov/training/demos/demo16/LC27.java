package by.lobanov.training.demos.demo16;

public class LC27 {


    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }

    // Передан массив чисел, преобразовать в номер телефона вида (ххх) ххх-хх-хх
    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
                numbers[0], numbers[1], numbers[2],
                numbers[3], numbers[4], numbers[5],
                numbers[6], numbers[7], numbers[8], numbers[9]);
    }

}
