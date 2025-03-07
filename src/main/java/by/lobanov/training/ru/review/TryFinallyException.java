package by.lobanov.training.ru.review;

// Какая ошибка выведется в консоль?
// * Как сделать выброс 1 ошибки без изменения кода
public class TryFinallyException {

    public static void main(String[] args) throws Exception {

        try {
            throw new Exception("1");
        } finally {
            throw new Exception("2");
        }
    }
}
