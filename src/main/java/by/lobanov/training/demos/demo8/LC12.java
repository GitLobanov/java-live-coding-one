package by.lobanov.training.demos.demo8;

public class LC12 {

    /**
     * Напишите метод, который принимает на вход массив последовательных (возрастающих) букв
     * и возвращает недостающую букву в массиве.
     *
     * Вы всегда получите действительный массив.
     * И всегда будет отсутствовать ровно одна буква.
     * Длина массива всегда будет не менее 2.
     *
     * Массив всегда будет содержать буквы только в одном регистре.
     *
     * Пример:
     * ['a','b','c','d','f'] -> 'e'
     * ['O','Q','R','S'] -> 'P'
     */

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'O','Q','R','S'}));
    }

    public static char findMissingLetter(char[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] + 1 != array[i+1]) {
                System.out.println(array[i] + 1);
                return (char) (array[i] + 1);
            }
        }

        return 0;
    }
}
