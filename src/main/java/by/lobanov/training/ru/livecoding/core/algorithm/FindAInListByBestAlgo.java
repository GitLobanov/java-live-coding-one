package by.lobanov.training.ru.livecoding.core.algorithm;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

/*
1. Есть класс А
2. Входной список отсортирован по i
3. Нужно найти элемент A.i = 18
4. Использовать бест алгоритм сложности
5. Вернуть один элемент в списке
6. Какая сложность будет подходить если нужно вернуть все возможные вхождения (несколько элементов)
 */
public class FindAInListByBestAlgo {

    @AllArgsConstructor
    public static class A {
        public Integer i;
        public String str;
    }

    // бинарный поиск в глубину
    public List<A> findA(List<A> list){

        Integer iSearch = 18;
        Integer low = 0;
        Integer high = list.size() - 1;

        while (low <= high){
            Integer midI = low + (high - low) / 2;
            A midElement = list.get(midI);

            if (Objects.equals(midElement.i, iSearch)){
                return List.of(midElement);
            } else if (midElement.i < iSearch) {
                high = midI - 1;
            } else {
                low = midI + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<A> list = List.of(
                new A(10, "a"),
                new A(12, "b"),
                new A(18, "c"),
                new A(25, "d"),
                new A(30, "e")
        );

        FindAInListByBestAlgo solution = new FindAInListByBestAlgo();
        List<A> result = solution.findA(list);

        if (result != null) {
            System.out.println("Найден элемент: " + result.get(0).str);
        } else {
            System.out.println("Элемент не найден.");
        }

    }



}
