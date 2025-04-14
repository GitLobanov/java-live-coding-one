package by.lobanov.training.ru.review.exception;

public class StackOverFlowMaxValue {

    public static void main(String[] args) {
        byte[] arr;
        try {
            arr = new byte[Integer.MAX_VALUE + Integer.MAX_VALUE + Integer.MAX_VALUE];
        } catch (Throwable e) {
            System.out.println("Поймана ошибка: " + e);
        } finally {
            System.out.println("finally block");
        }

        System.out.println("done");

        // arr = new byte[Integer.MAX_VALUE];
        // arr = new byte[Integer.MAX_VALUE - Integer.MAX_VALUE + Integer.MAX_VALUE];
    }
}
