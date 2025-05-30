package by.lobanov.training.ru.reviewcoding.extend;

public class CImplementsInterfaceABWithMethodRun {

    interface A {
        default void run() {
            System.out.println("A");
        }
    }

    interface B {
        default void run() {
            System.out.println("B");
        }
    }

//    class C implements A, B {
//    }

    class C implements A, B {
        @Override
        public void run() {
            A.super.run();
        } // Явное указание
    }

}
