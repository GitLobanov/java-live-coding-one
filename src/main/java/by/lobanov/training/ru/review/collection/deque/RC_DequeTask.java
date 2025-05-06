package by.lobanov.training.ru.review.collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RC_DequeTask {

    private Deque<String> deque = new ArrayDeque<>();
    public void method () {
        // какая-то логика работы с deque, например, описанная ниже:
        deque.add("string");
        deque.add("string2");
        System.out.println(String.join(", ", deque));
        deque.removeLast();
        deque.removeLast();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        RC_DequeTask task = new RC_DequeTask(); // Один экземпляр для всех потоков

        for (int i = 0; i < 4; i++) {
            executor.submit(task::method);
        }

        executor.shutdown(); // Важно: завершаем ExecutorService
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
