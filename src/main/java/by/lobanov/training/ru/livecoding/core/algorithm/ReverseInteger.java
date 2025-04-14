package by.lobanov.training.ru.livecoding.core.algorithm;

public class ReverseInteger {

    //Нужно написать метод, который переворачивает значение Integer:
    //120 -> 21
    //351 -> 153

    public static int reverse(int i){
        StringBuilder number = new StringBuilder(String.valueOf(Math.abs(i)));
        return Integer.parseInt(number.reverse().toString());
    }
}
