package by.lobanov.training.ru.review.multithreading;

import java.util.concurrent.TimeUnit;

public class StopThreadTest {

    private static Boolean stopRequested;

    public static void main(String[] args) throws Exception {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
