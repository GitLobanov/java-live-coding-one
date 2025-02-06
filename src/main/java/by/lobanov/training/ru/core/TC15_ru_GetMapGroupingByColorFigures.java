package by.lobanov.training.ru.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Как получить Map, где ключом является цвет геометрической фигуры, а значением — список фигур этого цвета?
 * <br>
 * Задача:
 * Условие:
 * Есть класс Shape с полем color, и несколько наследуемых классов для разных геометрических фигур. Необходимо получить карту (Map), где ключом будет цвет, а значением — список фигур этого цвета.
 * <br>
 * Задание:
 * Реализовать решение с использованием Stream API для группировки фигур по цвету.
 */
public class TC15_ru_GetMapGroupingByColorFigures {

    public static void main(String[] args) {
        List<Shape> input = List.of(
                new Circle("bob1", "зеленый"),
                new Square("bob2", "красный"),
                new Square("bob3", "желтый"),
                new Circle("bob4", "зеленый"),
                new Square("bob5", "черный")
        );
        Map<String, Long> groupMap = groupingByColorsFigures(input);
        System.out.println(groupMap);
    }

    private static Map<String, Long> groupingByColorsFigures (List<Shape> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Shape::getColor, Collectors.counting()));
    }

    @Data
    @AllArgsConstructor
    static class Shape {
        String name;
        String color;
    }
    static class Circle extends Shape {
        public Circle(String name, String color) {
            super(name, color);
        }
    }
    static class Square extends Shape {
        public Square(String name, String color) {
            super(name, color);
        }
    }
}
