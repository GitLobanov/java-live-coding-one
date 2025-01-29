package by.lobanov.training.ru.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.geo.Circle;

import java.util.List;


/**
 * Как получить только те геометрические фигуры, которые имеют свойство цвета "зеленый"?
 * <br>
 * Задача:
 * Условие:
 * Есть класс Shape с полем color (цвет), и несколько наследуемых классов для разных геометрических фигур, например, Circle, Square, и т.д. Необходимо получить список только тех фигур, которые имеют цвет "зеленый".
 * <br>
 * Задание:
 * Реализовать решение с использованием Stream API для фильтрации фигур по цвету.
 */
public class TC14_ru_FiguresFilterByColor {

    public static void main(String[] args) {
        List<Shape> input = List.of(
                new Circle("bob1", "зеленый"),
                new Square("bob2", "красный"),
                new Square("bob3", "желтый"),
                new Circle("bob4", "зеленый"),
                new Square("bob5", "черный")
                );
        List<Shape> greens = filterAndGetFiguresByColor(input, "зеленый");
        List<Shape> red = filterAndGetFiguresByColor(input, "красный");
        List<Shape> black = filterAndGetFiguresByColor(input, "черный");
        System.out.println(
                greens + "\n" +
                red + "\n" +
                black
        );
    }

    private static List<Shape> filterAndGetFiguresByColor(List<Shape> figures, String color) {
        return figures.stream()
                .filter(figure -> figure.getColor().equals(color))
                .toList();
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


