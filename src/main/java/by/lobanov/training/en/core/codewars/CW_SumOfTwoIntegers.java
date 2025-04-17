package by.lobanov.training.en.core.codewars;

/*
Given Two integers a , b , find The sum of them , BUT
!! You are not allowed to use the operators + and -
 */
public class CW_SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(add(1, 2) == 3);
        System.out.println(add(5, 19) == 24);
        System.out.println(add(23, 17) == 40);
    }

    public static int add(int x, int y) {
        if (y == 0) return x;
        int sum = x ^ y;
        int c = (x & y) << 1;
        return add(sum , c);
    }

//    public static int sneakyAdd(int x, int y) {
//        return \u0078\u002b\u0079;
//    }
}
