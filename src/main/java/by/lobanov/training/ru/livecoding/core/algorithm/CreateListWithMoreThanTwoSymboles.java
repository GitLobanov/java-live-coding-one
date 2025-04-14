package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateListWithMoreThanTwoSymboles {

    /**
     * Дан список строк {"a", "bb", "ccc", "dddd"}. Создайте новый список, содержащий только строки
     * длиной более 2 символов.
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "bb", "ccc", "dddd"));
        solution1(list);
        solution2(list);
    }

    private static void solution1(List<String> list) {
        List<String> copyList = new ArrayList<>(list);
        copyList.removeIf(el -> el.length() <= 2);
        System.out.println(copyList);
    }

    private static void solution2(List<String> list) {
        List<String> listResult = list.stream().filter(el -> el.length() > 1).toList();
        System.out.println(listResult);
    }
}
