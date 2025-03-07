package by.lobanov.training.ru.review;

// что выведется в консоль
public class MultiThreading {

    private static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread("myThread");
        myThread.start();
        myThread.run();
        myThread.run();
        myThread.start();
        myThread.run();
    }

}