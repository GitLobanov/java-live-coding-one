package by.lobanov.training.ru.reviewcoding.extend.abc;

public class AbcConstructor1 {

    public static class A {
        public A() {
            System.out.println("A");
        }
    }

    public static class B extends A{
        public B() {
            System.out.println("B");
        }
    }

    public static class C extends B {

        public C() {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        C c = new C();
    }

}
