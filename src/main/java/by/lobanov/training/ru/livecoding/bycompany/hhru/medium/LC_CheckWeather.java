package by.lobanov.training.ru.livecoding.bycompany.hhru.medium;

public class LC_CheckWeather {

    public static void main(String[] args) {
        System.out.println(findDrops("0 5 2 7 4 1"));
        System.out.println(findDrops("10 8 6 4 2 0 -2 -4"));
    }

    public static String findDrops(String input) {
        String[] parts = input.split(" ");
        int[] temperatures = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            temperatures[i] = Integer.parseInt(parts[i]);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i - 1] - temperatures[i] >= 3) {
                result.append(i).append(" ");
            }
        }

        if (result.length() == 0) {
            return "Нет";
        } else {
            return result.toString().trim();
        }
    }
}
