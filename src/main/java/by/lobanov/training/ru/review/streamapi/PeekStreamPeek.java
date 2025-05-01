package by.lobanov.training.ru.review.streamapi;

import java.util.stream.Stream;

public class PeekStreamPeek {

    public static void main(String[] args) {
        int b = (int) Stream.of(1,3,6,7)
                .peek(a-> System.out.println(a))
                .count();
        System.out.println(b);
    }

    /*
         Ответ: 6,7,2. Второй peek() не отработает, так как не изменяет ничего
         и будет оптимизирован стримом
     */
}
