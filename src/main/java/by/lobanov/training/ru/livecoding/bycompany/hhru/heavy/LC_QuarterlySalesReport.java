package by.lobanov.training.ru.livecoding.bycompany.hhru.heavy;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * Отчёт о продажах за квартал
 * <p>
 * Вы работаете над модулем для CRM-системы, который помогает менеджерам по продажам готовить автоматизированные отчёты.
 * Данные о продажах поступают в формате Дата:Продукт:Количество;Дата:Продукт:Количество;....
 * <p>
 * Напишите программу, которая принимает информацию о продажах по датам и возвращает отчёт о продажах за каждый квартал.
 * <p>
 * Формат ввода:
 * Одна строка с данными в формате Дата:Продукт:Количество;Дата:Продукт:Количество;....
 * <p>
 * Дата в формате YYYY-MM-DD.
 * Через двоеточие указано название продукта на русском языке.
 * Через ещё одно двоеточие — положительное число, указывающее количество проданных товаров.
 * Данные по продуктам разделены точкой с запятой.
 * <p>
 * Формат вывода:
 * Набор строк, в котором выводится информация о продажах товаров:
 * <p>
 * Сначала даётся номер квартала с двоеточием (например, Q1:).
 * На последующих строках — маркированный список с дефисом с названием товара и количеством продаж через двоеточие.
 * Количество продаж по одному продукту в одном квартале суммируется. Каждый пункт списка начинается с новой строки.
 * <p>
 * Кварталы идут по порядку, а товары внутри квартала сортируются по алфавиту.
 * Если в каком-то квартале не было продаж, он никак не отображается в отчёте.
 * <p>
 * Пример 1
 * Входные данные:
 * 2023-01-15:Книга:10;2023-04-20:Флешка:5;2023-07-05:Наушники:8
 * Выходные данные:
 * <p>
 * Q1:
 * - Книга: 10
 * Q2:
 * - Флешка: 5
 * Q3:
 * - Наушники: 8
 * <p>
 * Пример 2
 * Входные данные:
 * 2023-02-05:Шляпа:4;2023-03-20:Кольцо:7;2023-04-25:Браслет:6;2023-04-26:Браслет:12
 * Выходные данные:
 * <p>
 * Q1:
 * - Кольцо: 7
 * - Шляпа: 4
 * Q2:
 * - Браслет: 18
 * <p>
 * Решение:
 * Разбиение данных: Данные разбиваются по точке с запятой ; для получения отдельных записей.
 * Определение квартала: На основе месяца из даты определяется номер квартала (Q1, Q2, Q3, Q4).
 * Агрегация данных: Для каждого продукта суммируется количество продаж в рамках квартала.
 * Сортировка: Товары внутри квартала сортируются по алфавиту.
 * Форматирование результата: Формируется строка отчёта в нужном формате.
 */
public class LC_QuarterlySalesReport {

    public static void main(String[] args) {
        System.out.println(generateReport("2023-02-05:Шляпа:4;2023-03-20:Кольцо:7;2023-04-25:Браслет:6;2023-04-26:Браслет:12"));
        // Q1:
        // - Кольцо: 7
        // - Шляпа: 4
        // Q2:
        // - Браслет: 18
    }

    public static String generateReport(String salesData) {
        // Квартал <Продукт, Количество>
        Map<String, Map<String, Integer>> quarterSales = new TreeMap<>();

        for (String product : salesData.split(";")) {
            String[] productParts = product.split(":");
            LocalDate datePart = LocalDate.parse(productParts[0]);
            String namePart = productParts[1];
            Integer amountPart = Integer.parseInt(productParts[2]);

            String quarter = getQuarterFrom(datePart);
            quarterSales.putIfAbsent(quarter, new TreeMap<>());

            Map<String, Integer> mapProduct = quarterSales.get(quarter);
            Integer amount = mapProduct.getOrDefault(namePart, 0);
            mapProduct.put(namePart, amount + amountPart);
        }

        StringBuilder sb = new StringBuilder();
        quarterSales.forEach((quarter, products) -> {
            sb.append(String.format("%s:", quarter)).append("\n");
            products.forEach((nameProduct, amount) ->
                    sb.append(String.format("- %s: %d", nameProduct, amount)).append("\n"));
        });
        return sb.toString().trim();
    }

    private static String getQuarterFrom(LocalDate date) {
        int month = date.getMonthValue();

        return switch (month) {
            case 1, 2, 3 -> "Q1";
            case 4, 5, 6 -> "Q2";
            case 7, 8, 9 -> "Q3";
            case 10, 11, 12 -> "Q4";
            default -> "";
        };
    }
}
