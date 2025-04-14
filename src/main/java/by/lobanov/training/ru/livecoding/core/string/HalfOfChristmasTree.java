package by.lobanov.training.ru.livecoding.core.string;

/*
реализовать вывод половины ёлочки, с динамичным выводом
   *
  **
 ***
****
   *
  **
 ***
****
   *
  **
 ***
****
 */
public class HalfOfChristmasTree {

    public static void main(String[] args) {
        int maxLevelsPerSegment = 3;
        int segments = 3;

        printTree(maxLevelsPerSegment, segments);
    }

    public static void printTree(int levels, int segments) {
        for (int s = 0; s < segments; s++) {
            for (int level = 0; level <= levels; level++) {
                int spaces = levels - level;

                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < level; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    public static void printTree2(int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print((j < h - 1 - i) ? " " : "*");
            }
            System.out.println();
        }
    }

    public static void printTreeOn(int levels, int segments) {
        int totalLevels = levels * segments;

        for (int i = 0; i < totalLevels; i++) {
            int levelInSegment = i % levels;
            int spaces = levels - 1 - levelInSegment;
            int stars = levelInSegment + 1;

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
