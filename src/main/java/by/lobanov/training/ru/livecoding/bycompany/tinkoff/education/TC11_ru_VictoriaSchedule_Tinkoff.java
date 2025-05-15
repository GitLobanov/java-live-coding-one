package by.lobanov.training.ru.livecoding.bycompany.tinkoff.education;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <br>
 * Виктория считает i-й (3 <= i < n)  день хорошим, если в этот день она пробежит не меньше, чем в первый день, и не больше, чем во второй день.
 * Расписание же ей понравится, если хотя бы  дней будут хорошими.
 * В расписании можно делать корректировки: произвольное ai (1 <= i < n)  можно увеличить или уменьшить на 1 километр.
 * Разрешается корректировать один и тот же день несколько раз.
 *
 * <br>
 * Формат входных данных
 * Первая строка содержит числа n (3 <= n <= 2 * 10^5) и m (1 <= m <= n -2) — количество дней до лета и количество хороших дней, которое необходимо Виктории, чтобы ей понравилось расписание.
 * Следующая строка содержит числа a1, a2, ..., an (1 <= ai <= 1^9), где a — количество километров, которое должна пробежать Виктория согласно начальному расписанию.
 * <br>
 * Формат выходных данных
 * Выведите одно число — минимальное количество корректировок, которое необходимо внести в расписание, чтобы оно понравилось Виктории.
 * <br>
 * Комментарий к примеру
 * В примере можно дважды уменьшить  на единицу, чтобы расписание понравилось Виктории.
 * <br>
 * Input
 * 3 1
 * 3 4 6
 * <br>
 * Output
 * 2
 */
public class TC11_ru_VictoriaSchedule_Tinkoff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] schedule = new int[n];

        for (int i = 0; i < n; i++) {
            schedule[i] = sc.nextInt();
        }

        int lowerLimit = schedule[0];
        int upperLimit = schedule[1];

        int goodDays = 0;
        List<Integer> corrections = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            if (schedule[i] >= lowerLimit && schedule[i] <= upperLimit) {
                goodDays++;
            } else {
                if (schedule[i] < lowerLimit) {
                    corrections.add(lowerLimit - schedule[i]);
                } else if (schedule[i] > upperLimit) {
                    corrections.add(schedule[i] - upperLimit);
                }
            }
        }

        if (goodDays >= m) {
            System.out.println(0);
            return;
        }

        int changesRequired = 0;
        int daysToFix = m - goodDays;

        Collections.sort(corrections);

        for (int i = 0; i < daysToFix; i++) {
            changesRequired += corrections.get(i);
        }

        System.out.println(changesRequired);
    }
}
