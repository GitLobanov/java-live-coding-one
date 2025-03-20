package by.lobanov.training.ru.review.generics;

import java.util.ArrayList;
import java.util.List;

public class PecsWildcard {

    static sealed class A permits B {}
    static sealed class B extends A permits C {}
    static final class C extends B {}

    public static void main(String[] args) {
//        What can be assigned to Collection<? super B>?
//        What can be assigned to Collection<? extends B>?

//        Collection<C>
//        Collection<A>
//        List<? extends B>
//        List<? super B>
//        Iterable<? extends B>
//        Iterable<? super B>
//        null

//        Collection<A> collectionA = new ArrayList<>();
//        Collection<B> collectionB = new ArrayList<>();
//        Collection<C> collectionC = new ArrayList<>();
//        Collection<? super B> collection = collectionA;

        A elemA = new A();
        B elemB = new B();
        C elemC = new C();
        Object elemO = new Object();

        List<? super B> collectionSuper = new ArrayList<>();
//        collectionSuper.add(elemA);
//        A a1 = collectionSuper.get(0);
//        Object o1 = collectionSuper.get(0);
//        collectionSuper.add(elemB);
//        collectionSuper.add(elemC);
//        collectionSuper.add(elemO);
//        collectionSuper.add(null);

        List<? extends B> collectionExtends = new ArrayList<>();
//        collectionExtends.add(elemA);
//        A a2 = collectionExtends.get(0);
//        Object o2 = collectionSuper.get(0);
//        collectionExtends.add(elemB);
//        collectionExtends.add(elemC);
//        collectionExtends.add(elemO);
//        collectionExtends.add(null);
    }
}
