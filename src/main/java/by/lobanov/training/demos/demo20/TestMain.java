package by.lobanov.training.demos.demo20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMain {

    public interface IOne {
        int doAction(String param);
    }

    public interface ITwo {
        int doAction(String param);
    }

    static class OneTwo implements IOne, ITwo {

        @Override
        public int doAction(String param) {
            return 21;
        }

        public static void main(String[] args) {
            var oneTwo = new OneTwo();
            var result = oneTwo.doAction("param-value");
            System.out.println(result);
        }
    }
}
