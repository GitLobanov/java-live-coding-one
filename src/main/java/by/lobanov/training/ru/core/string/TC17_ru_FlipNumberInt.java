package by.lobanov.training.ru.core.string;

/**
 * Перевернуть число - 120 -> 21, 351 -> 153
 */
public class TC17_ru_FlipNumberInt {

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(351));
        System.out.println(reverse(400003010));
    }
    public static int reverse(int i){
        StringBuilder number = new StringBuilder(String.valueOf(Math.abs(i)));
        return Integer.parseInt(number.reverse().toString());
    }
}
