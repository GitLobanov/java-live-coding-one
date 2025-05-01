package by.lobanov.training.ru.review.generics;

import java.util.ArrayList;
import java.util.List;

public class PecsFruits {

    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<>();
//        fruits.add(new Apple());
//        fruits.add(new Orange());
//        fruits.add(new Fruit());
    }

    private static class Fruit {}
    private static class Apple extends Fruit {}
    private static class Orange extends Fruit {}
}
