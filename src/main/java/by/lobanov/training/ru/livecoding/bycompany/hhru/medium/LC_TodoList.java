package by.lobanov.training.ru.livecoding.bycompany.hhru.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_TodoList {

    public static void main(String[] args) {
        System.out.println(manageTasks("ADD,НаписатьКод,2;ADD,ТестироватьКод,3;ADD,ОтветитьНаСообщения,1;REMOVE;GET"));
        System.out.println(manageTasks("REMOVE;ADD,КупитьПродукты,3;REMOVE;ADD,СделатьУборку,2;ADD,Постирать,5;ADD,Погладить,5;GET"));
        System.out.println(manageTasks("ADD,ПосетитьВстречу,2;REMOVE;ADD,ПрочитатьГазету,1;REMOVE;GET"));
    }

    private static class Task {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + "," + priority;
        }
    }

    private static final List<Task> tasks = new ArrayList<>();

    private static String manageTasks(String input) {
        String[] commands = input.split(";");

        for (String command : commands) {
            if (command.startsWith("ADD")) {
                String[] parts = command.split(",");
                String name = parts[1];
                int priority = Integer.parseInt(parts[2]);
                tasks.add(new Task(name, priority));
            } else if (command.equals("REMOVE")) {
                if (!tasks.isEmpty()) {
                    Task highestPriorityTask = Collections.min(tasks,
                            Comparator.comparingInt((Task t) -> t.priority)
                                    .thenComparing(t -> t.name)
                    );
                    tasks.remove(highestPriorityTask);
                }
            } else if (command.equals("GET")) {
                if (tasks.isEmpty()) {
                    return "Список пуст";
                } else {
                    tasks.sort(
                            Comparator.comparingInt((Task t) -> t.priority)
                                    .thenComparing(t -> t.name)
                    );
                    StringBuilder result = new StringBuilder();
                    for (Task t : tasks) {
                        result.append(t).append(";");
                    }
                    return result.substring(0, result.length() - 1);
                }
            }
        }
        return "";
    }
}
