package by.lobanov.training.ru.livecoding.core.bycompany.yandex.trainee;

import java.util.Scanner;

public class LC_ApartmentBuilding {

    // n - floors
    // m - apartment
    // x - windows in height
    // y - windows in width
    // X - window is lighting, 0 - light is turn off
    // input:
    // n m x y
    // X000
    // Определить сколько жильцов еще не спит
    // Свет должен гореть хотя бы в половине окон, тогда можно считать что жильцы еще не спят
    // Формула: (x * y) / 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // количество этажей
        int m = sc.nextInt(); // количество квартир на этаже
        int x = sc.nextInt(); // количество окон в высоту в квартире
        int y = sc.nextInt(); // количество окон в ширину в квартире
        sc.nextLine(); // переход на следующую строку

        // Чтение данных о состоянии окон
        char[][] windows = new char[n * x][m * y];
        for (int i = 0; i < n * x; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m * y; j++) {
                windows[i][j] = line.charAt(j);
            }
        }

        int awakeApartments = 0;
        int threshold = (int) Math.ceil((x * y) / 2.0);

        // Перебор всех квартир
        for (int floor = 0; floor < n; floor++) {
            for (int apartment = 0; apartment < m; apartment++) {
                int count = 0;
                // Перебор окон квартиры
                for (int windowX = 0; windowX < x; windowX++) {
                    for (int windowY = 0; windowY < y; windowY++) {
                        int globalX = floor * x + windowX;
                        int globalY = apartment * y + windowY;
                        if (windows[globalX][globalY] == 'X') {
                            count++;
                        }
                    }
                }
                if (count >= threshold) {
                    awakeApartments++;
                }
            }
        }

        System.out.println(awakeApartments);

    }
}
