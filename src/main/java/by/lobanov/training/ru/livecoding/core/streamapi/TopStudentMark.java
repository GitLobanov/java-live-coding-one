package by.lobanov.training.ru.livecoding.core.streamapi;

import lombok.val;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopStudentMark {

    static class StudentMark {
        private final int id;
        private final int mark;

        public StudentMark(int id, int mark) {
            this.id = id;
            this.mark = mark;
        }

        public int getId() {
            return id;
        }

        public int getMark() {
            return mark;
        }

        @Override
        public String toString() {
            return "StudentMark{" +
                    "id=" + id +
                    ", mark=" + mark +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<StudentMark> studentMarks = List.of(
                new StudentMark(1, 5),
                new StudentMark(1, 4),
                new StudentMark(2, 3),
                new StudentMark(2, 5),
                new StudentMark(3, 5),
                new StudentMark(3, 5),
                new StudentMark(4, 4),
                new StudentMark(4, 3),
                new StudentMark(5, 5),
                new StudentMark(5, 5),
                new StudentMark(6, 3),
                new StudentMark(6, 2)
        );

        // а) Нужно с помощью стрима найти топ 5 студентов с лучшей оценкой
        studentMarks.stream()
                .collect(Collectors.toMap(
                        StudentMark::getId,
                        Function.identity(),
                        (st1, st2) -> st1.getMark() > st2.getMark() ? st1 : st2
                )).values().stream()
                .sorted(Comparator.comparing((StudentMark studentMark) -> studentMark.mark).reversed())
                .limit(5)
                .forEach(System.out::println);
        // б) Нужно найти топ 5 студентов с лучшей средней оценкой
        val collect = studentMarks.stream()
                .collect(Collectors.groupingBy(
                        StudentMark::getId,
                        Collectors.averagingDouble(StudentMark::getMark)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(5)
                .toList();
        System.out.println(collect);
    }
}
