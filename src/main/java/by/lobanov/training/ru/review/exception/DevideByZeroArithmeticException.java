package by.lobanov.training.ru.review.exception;

public class DevideByZeroArithmeticException {

    // что выведется в консоль?
    public static void main(String[] args) {
        try {
            double val = 10/0.0;
            System.out.println("1");
        } catch (ArithmeticException ex) {
            System.out.println("2");
            throw new RuntimeException();
        } catch (Throwable ex) {
            System.out.println("3");
            throw new RuntimeException();
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
        // ...
    }
}
