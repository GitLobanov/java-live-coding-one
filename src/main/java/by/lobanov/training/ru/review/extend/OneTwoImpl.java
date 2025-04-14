package by.lobanov.training.ru.review.extend;

public class OneTwoImpl {

    interface One {
        default void method1() {
            System.out.println("One-method1");
        }
        void method2();
    }

    @FunctionalInterface
    interface Two extends One {
        default void method1() {
            System.out.println("Two-method1");
        }
    }

    public static class TwoImpl implements Two {
        public void method2() {
            System.out.println("TwoImpl-method2");
        }

        public static void main(String[] args) {
            TwoImpl t = new TwoImpl();
            t.method1();
        }
    }
}
