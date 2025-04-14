package by.lobanov.training.ru.review.exception;

import java.util.Arrays;

/**
 * Нужно понять как лучше обратать ошибку в
 * .filter(this::isMoreThanTwo)
 */
public class Review_HandleExceptionInStream {

//    public int[] filterArray() {
//        return Arrays.stream(new int[]{1, 2, 3})
//                .filter(this::isMoreThanTwo)
//                .toArray();
//    }

    private boolean isMoreThanTwo(int number) throws Exception {
        if (number > 2) {
            return true;
        }
        return somethingWrong();
    }

    public boolean somethingWrong() throws Exception {
        throw new Exception();
    }

    /* 1 answer
    private boolean isMoreThanTwo(int number) {
        if (number > 2) {
            return true;
        }
        try {
            return somethingWrong();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     */

    /* 2 answer
    public int[] filterArray() {
        return Arrays.stream(new int[]{1, 2, 3})
                .filter(value -> {
                    try {
                        return isMoreThanTwo(value);
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                })
                .toArray();
    }
     */
}
