package by.lobanov.training.ru.core.livecoding.math;

import java.util.TreeMap;


/**
 * Реализовать конвертер из арабских чисел в римские. Диапазон римских чисел от 1 до 3999. В римских числах не может быть больше 3 одинаковых символов подряд
 * 1000, "M"
 * 900, "CM"
 * 500, "D"
 * 400, "CD"
 * 100, "C"
 * 90, "XC"
 * 50, "L"
 * 40, "XL"
 * 10, "x"
 * 9, "IX"
 * 5,"V"
 * 4,"IV"
 * 1,"1"
 * Example:
 * 1986 -> MCMLXXXVI
 */
public class TC18_ru_IntegerToRomanSymbols_LC {

    private static TreeMap<Integer, String> map = new TreeMap<>();
    // TODO need assign number and roman symb in map

    public static String convert(int n) {
        String s  = "";
        while (n != 0) {
            var e = map.floorEntry(n);
            s += e.getValue();
            n = e.getKey();
        }
        return s;
    }
}