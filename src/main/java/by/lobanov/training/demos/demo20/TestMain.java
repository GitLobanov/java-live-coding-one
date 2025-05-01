package by.lobanov.training.demos.demo20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMain {

    static class Parent {

        public int age = 50;

        public void method() {
            System.out.println("parent method work");
        }

        public void printAge() {
            System.out.println(age);
        }
    }

    static class Child extends Parent {
        public int age = 20;

        @Override
        public void method() {
            System.out.println("child method work");
        }

        @Override
        public void printAge() {
            System.out.println(age);
        }
    }

    public static void main(String[] args) {
        Parent object = new Child();
        object.method();
        object.printAge();
    }
}
