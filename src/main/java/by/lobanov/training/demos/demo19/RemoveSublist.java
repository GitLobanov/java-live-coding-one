package by.lobanov.training.demos.demo19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RemoveSublist {

    // Предложите эффективный алгоритм удаления нескольких рядом стоящих элементов из середины списка, реализуемого ArrayList.
    // 1111111258874123  удалить под лист 874 ->  11111112584123
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,2,5,8,8,7,4,1,2,3));
        List<Integer> sublist = Arrays.asList(8,7,4);
        System.out.println(removeSublist(list, sublist));
    }

    private static List<Integer> removeSublist(List<Integer> list, List<Integer> sublist) {
        if (sublist.isEmpty()) return list;

        int subSize = sublist.size();
        int listSize = list.size();

        for (int i = 0; i <= listSize - subSize; i++) {
            boolean match = true;

            for (int j = 0; j < subSize; j++) {
                if (!Objects.equals(list.get(i + j), sublist.get(j))) {
                    match = false;
                    break;
                }
            }

            if (match) {
                list.subList(i, i + subSize).clear();
                return list;
            }
        }

        return list;
    }
}
