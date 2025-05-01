package by.lobanov.training.ru.livecoding.core.algorithm;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

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
                low = midI + 1;
            } else {
                high = midI - 1;
            }
        }

        return new ArrayList<>();
    }

    public List<A> findABfs(List<A> list, Integer target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            A currentElement = list.get(currentIndex);

            if (Objects.equals(currentElement.i, target)) {
                return List.of(currentElement);
            }

            int nextIndex = currentIndex + 1;
            if (nextIndex < list.size() && !visited.contains(nextIndex)) {
                queue.offer(nextIndex);
                visited.add(nextIndex);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<A> list = List.of(
                new A(7, "a"),
                new A(11, "b"),
                new A(12, "c"),
                new A(18, "d"),
                new A(19, "e"),
                new A(20, "f"),
                new A(21, "g"),
                new A(22, "h"),
                new A(23, "m"),
                new A(25, "n"),
                new A(26, "p"),
                new A(27, "r"),
                new A(29, "s"),
                new A(30, "t")
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
