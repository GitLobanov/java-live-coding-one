package by.lobanov.training.ru.livecoding.core.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CollectionStudents {

    @Data
    @AllArgsConstructor
    public static class Student {
        private String lastName;
        private String firstName;
        private String middleName;
        private String specialty;
        private boolean admission;

    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "Иван", "Иванович", "Математика", false),
                new Student("Петров", "Петр", "Петрович", "Физика", false),
                new Student("Сидоров", "Сидор", "Сидорович", "Информатика", false))
                // Добавьте остальных абитуриентов
        );

        // 1. Выполнить сортировку списка абитуриентов в алфавитном порядке по убыванию
        students.sort(Comparator.comparing(Student::getLastName).reversed());

        // 2. В случайном порядке проставить признак поступления
        Random random = new Random();
        students.forEach(student -> student.setAdmission(random.nextBoolean()));

        // 3. Вывести список абитуриентов и их количество
        System.out.println("Список абитуриентов:");
        students.forEach(System.out::println);
        System.out.println("Количество абитуриентов: " + students.size());

        // 4. Отдельным списком вывести всех поступивших+специальность и НЕ поступивших
        List<Student> admittedStudents = students.stream()
                .filter(Student::isAdmission)
                .collect(Collectors.toList());
        List<Student> nonAdmittedStudents = students.stream()
                .filter(student -> !student.isAdmission())
                .collect(Collectors.toList());

        System.out.println("Поступившие:");
        admittedStudents.forEach(System.out::println);
        System.out.println("НЕ поступившие:");
        nonAdmittedStudents.forEach(System.out::println);
    }

}
