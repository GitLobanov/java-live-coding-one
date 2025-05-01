package by.lobanov.training.ru.review.equals;

public class TaskEquals {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        String s1 = "123";
        String s2 = String.valueOf(123);
        System.out.println("s1 equals s2: " + s1.equals(s2));
    }
}
