package by.lobanov.training.ru.livecoding.core.string;

/*
реализовать вывод елечки, с динамичным подходом
    *
   ***
 ******
********
    *
   ***
 ******
********
    *
   ***
 ******
********
 */
public class LC_ChristmasTree {

    public static void main(String[] args) {
        int maxLevelsPerSegment = 4; // количество уровней в одной ветке
        int segments = 3;         // количество повторяющихся веток

        printTree(maxLevelsPerSegment, segments);
    }

    public static void printTree(int levels, int segments) {
        int maxWidth = levels * 2 - 1;

        for (int s = 0; s < segments; s++) {
            for (int i = 1; i <= levels; i++) {
                int stars = i * 2 - 1;
                int spaces = (maxWidth - stars) / 2;

                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

}
