package by.lobanov.training.ru.livecoding.bycompany.tinkoff.education;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <br>
 * Герман немного устал. Вот бы кто-нибудь сделал за него домашнее задание...
 * <br>
 * Задача, которую необходимо решить Герману, звучит следующим образом. Дана последовательность a1, a2, ... ,  и числа x, y, z.
 * <br>
 * Разрешается произвольное количество (в том числе ноль) раз выполнить следующую операцию: выбрать произвольное i (1 <= i <= n)
 * и увеличить ai на единицу.
 * <br>
 * Необходимо, чтобы хотя бы один элемент из последовательности делился на x, хотя бы один элемент делился на y и хотя бы один элемент делился на z.
 * Разрешается, чтобы для разных значений из набора (x,y,z) подходил один и тот же элемент из последовательности.
 * <br>
 * Помогите Герману отдохнуть перед сессией и найдите минимальное количество операций, которое необходимо выполнить, чтобы условие стало выполнено.
 * Формат входных данных
 * Первая строка содержит числа  n (1 <= n <= 2 * 10^5), x,y, и z.
 * Вторая строка содержит числа a1, a2, ... ,  an.
 * Формат выходных данных
 * Выведите одно число — минимальное количество операций, которое надо выполнить, чтобы для каждого из чисел x, y, z был хотя бы один элемент в последовательности, кратный данному числу.
 * Комментарий к примеру
 * В примере можно дважды увеличить a4 и один раз увеличить a5. Тогда на 10 будет делиться a4, на 20 будет делиться a5, на 30 будет делиться a4.
 * <br>
 * Input
 * 6 10 20 30
 * 8 17 5 28 39 13
 * Output
 * 3
 */
public class TC12_ru_Tinkoff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод данных
        int n = sc.nextInt();  // Количество элементов в массиве
        int x = sc.nextInt();  // Число x
        int y = sc.nextInt();  // Число y
        int z = sc.nextInt();  // Число z

        int[] a = new int[n];  // Массив a

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Минимальные операции для x, y, z
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minZ = Integer.MAX_VALUE;

        // Проходим по массиву и находим минимальное количество операций для каждого x, y, z
        for (int i = 0; i < n; i++) {
            // Для x
            int opX = (x - (a[i] % x)) % x;
            minX = Math.min(minX, opX);

            // Для y
            int opY = (y - (a[i] % y)) % y;
            minY = Math.min(minY, opY);

            // Для z
            int opZ = (z - (a[i] % z)) % z;
            minZ = Math.min(minZ, opZ);
        }

        // Суммируем минимальные операции для каждого из x, y, z
        int result = minX + minY + minZ;

        // Выводим результат
        System.out.println(result);
    }

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
    public static class TC14_ru_FiguresFilterByColor {

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
    public static class TC15_ru_GetMapGroupingByColorFigures {

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
}
