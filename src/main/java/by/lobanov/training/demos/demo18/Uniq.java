package by.lobanov.training.demos.demo18;

import java.util.Arrays;

public class Uniq {

    /*
Вывести количество уникальных символов во всём массиве строк
Например: ["ABC", "DEF", "ADL", "PLA"]  -> 8
*/

    public static void main(String[] args) {

    }

    public static int uniqueCharacters(String[] strings) {
        return (int) Arrays.stream(strings)
                .flatMapToInt(String::chars)
                .distinct()
                .count();
    }

}
