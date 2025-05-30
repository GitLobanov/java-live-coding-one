package by.lobanov.training.ru.reviewcoding.extend.abc;

public class AbcConstructor2 {

    public static class A {
        final int x;

        public A() {
            x = getValue();
        }

        int getValue () {
            return 42;
        }
    }

    public static class B extends A{
        int y = 100;

        @Override
        int getValue () {
            return y;
        }
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.x);
    }
}
