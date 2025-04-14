package by.lobanov.training.ru.review.exception;

public class StackOverFlowExpection {

    // что выведется в консоль?
    public static void main(String[] args) {
        try {
            int d = recursiveMethod(1);
            System.out.println(d);
        } catch (RuntimeException ex) {
            System.out.println("2");
            throw new RuntimeException();
        } catch (Throwable ex) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
        // ...
    }

    public static int recursiveMethod(int num) {
        return recursiveMethod(num + 1);
    }
}
