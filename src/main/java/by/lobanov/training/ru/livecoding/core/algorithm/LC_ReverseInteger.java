package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

//Нужно написать метод, который переворачивает значение Integer:
//120 -> 21
//351 -> 153
public class LC_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse1(123));
        System.out.println(reverse1(7890));
        System.out.println(reverse1(456));
        System.out.println(reverse1(-456));
    }

    public static int reverse(int i){
        StringBuilder number = new StringBuilder(String.valueOf(Math.abs(i)));
        return Integer.parseInt(number.reverse().toString());
    }

    public static int reverse1(int i){
        Deque<Character> d = new ArrayDeque<>();

        String str = String.valueOf(Math.abs(i));
        for (Character ch : str.toCharArray()) {
            d.addFirst(ch);
        }

        StringJoiner sj = new StringJoiner("");
        for (Character ch : d) {
            sj.add(String.valueOf(ch));
        }

        return Integer.parseInt(sj.toString());
    }

}
