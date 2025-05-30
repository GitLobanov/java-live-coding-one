package by.lobanov.training.ru.reviewcoding.orderinit;

public class Case1 {

    static {
        System.out.println("Static block");
        x = 10;
    }

    static int x = 5;

    public static void main(String[] args) {
        System.out.println("x = " + x);
    }
}
