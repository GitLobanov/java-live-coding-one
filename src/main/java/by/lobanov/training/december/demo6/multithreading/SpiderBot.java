package by.lobanov.training.december.demo6.multithreading;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class SpiderBot {

    private final ExecutorService executorService;   // Пул потоков для работы с задачами
    private final List<Sensor> sensors;             // Список датчиков
    private final List<Task> tasks;                 // Список задач

    private final Lock movementLock = new ReentrantLock();  // Блокировка для синхронизации движения
    private final CountDownLatch dataLatch;                // Для ожидания завершения сбора данных
    private final Semaphore taskSemaphore;                 // Ограничение количества задач одновременно

    // Датчик
    @Data
    @RequiredArgsConstructor
    public static class Sensor {
        private final String type;
        private final double value;
    }

    // Задача
    @Data
    @RequiredArgsConstructor
    public static class Task {
        private final String name;
        private final int duration;  // Длительность задачи в миллисекундах
    }

    public SpiderBot(List<Sensor> sensors, List<Task> tasks) {
        this.executorService = Executors.newFixedThreadPool(4);  // Пул из 4 потоков
        this.sensors = sensors;
        this.tasks = tasks;
        this.dataLatch = new CountDownLatch(sensors.size());  // Ожидание для каждого датчика
        this.taskSemaphore = new Semaphore(2);  // Ограничение на выполнение 2 задач одновременно
    }

    /**
     * 1. Движение робота (используем блокировку для предотвращения одновременного доступа)
     */
    public void move() {
        movementLock.lock();
        try {
            System.out.println("SpiderBot is moving...");
            Thread.sleep(1000);  // Имитируем движение
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            movementLock.unlock();
        }
    }

    /**
     * 2. Сбор данных с датчиков
     */
    public void collectData(Sensor sensor) {
        try {
            System.out.println("Collecting data from sensor: " + sensor.getType());
            // Имитируем работу датчика
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            dataLatch.countDown();  // Уменьшаем счетчик после сбора данных
        }
    }

    /**
     * 3. Выполнение задач с ограничением по параллельности
     */
    public void executeTask(Task task) {
        try {
            taskSemaphore.acquire();  // Захватываем семафор для ограничения задач
            System.out.println("Executing task: " + task.getName());
            Thread.sleep(task.getDuration());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            taskSemaphore.release();  // Освобождаем семафор после выполнения задачи
        }
    }

    /**
     * 4. Обработка всех данных (ждем, пока все данные будут собраны)
     */
    public void processData() {
        try {
            dataLatch.await();  // Ожидаем, пока все датчики завершат сбор данных
            System.out.println("All data collected, processing...");
            // Имитируем обработку данных
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 5. Основной метод для выполнения всех операций
     */
    public void start() {
        // Запускаем потоки для сбора данных с датчиков
        for (Sensor sensor : sensors) {
            executorService.submit(() -> collectData(sensor));
        }

        // Запускаем задачи
        for (Task task : tasks) {
            executorService.submit(() -> executeTask(task));
        }

        // Даем роботу двигаться (синхронизация движения)
        executorService.submit(this::move);

        // Ждем завершения сбора данных
        processData();

        // Закрываем пул потоков
        executorService.shutdown();
    }

    public static void main(String[] args) {
        List<Sensor> sensors = Arrays.asList(
                new Sensor("Temperature", 25.3),
                new Sensor("Motion", 0.5),
                new Sensor("Humidity", 60.0)
        );

        List<Task> tasks = Arrays.asList(
                new Task("Scan Area", 2000),
                new Task("Collect Samples", 3000),
                new Task("Return to Base", 1500)
        );

        SpiderBot spiderBot = new SpiderBot(sensors, tasks);
        spiderBot.start();
    }
}
