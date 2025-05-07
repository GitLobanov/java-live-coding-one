package by.lobanov.training.ru.livecoding.core.bycompany.tinkoff.education;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Difficulty: easy
 * <br>
 * Рассмотрим три числа
 * a, b, c Упорядочим их по возрастанию.
 * Какое число будет стоять между двумя другими?
 */
public class TC1_MiddleElement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] arr = reader.readLine().split(" ");
        Arrays.sort(arr, Comparator.reverseOrder());

        writer.write(arr[1]);

        reader.close();
        writer.close();
    }
}
