package by.lobanov.training.ru.livecoding.core.bycompany.tinkoff.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Выведите , если символ  находится в строке  раньше, чем символ . В противном случае выведите .
 */
public class TC9_ru_CheckSymbolR_Tinkoff {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String isStringGood = checkSymbolR(input);
        System.out.println(isStringGood);
    }

    public static String checkSymbolR(String str) {
        return Arrays.stream(str.split(""))
                .filter(letter -> letter.equals("R") || letter.equals("M"))
                .limit(1)
                .map(d -> d.equals("R") ? "Yes" : "No")
                .collect(Collectors.joining());
    }
}
