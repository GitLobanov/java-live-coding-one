package by.lobanov.training.ru.livecoding.bycompany.hhru.heavy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Рейтинг по предмету
 * Вы работаете над модулем «Электронная зачётка» в системе для администрирования учебного процесса регионального вуза.
 * Каждый студент может быть записан на несколько курсов, по каждому курсу у него есть итоговый балл.
 *
 * Необходимо написать программу для учебного офиса. Программа будет получать и хранить списки студентов,
 * а также итоговый балл студента по каждому курсу. Программа также должна уметь составлять отсортированный список студентов,
 * которые набрали строго больше проходного балла по определённому предмету. Сортировка идёт по убыванию баллов студентов за этот предмет.
 *
 * Формат ввода:
 *
 * Первая строка содержит информацию о студентах, курсах и их оценках в формате:
 * <имя_студента,курс,оценка;имя_студента,курс,оценка;...>.
 * В строке есть информация хотя бы об одном студенте.
 * Вторая строка содержит предмет, по которому запрошена статистика, и его проходной балл:
 * <курс,проходной_балл>.
 * Все баллы являются целыми положительными числами, а все имена студентов уникальны.
 *
 * Формат вывода:
 * Имена студентов и их баллы за этот предмет через запятую без пробела, каждый студент с новой строки.
 * Выводятся только те студенты, кто набрал строго больше проходного балла по этому предмету.
 *
 * Если студенты набрали одинаковый балл, они сортируются в порядке ввода.
 * Если никто не набрал проходной балл, выводится слово «Никто» (без кавычек).
 * Пример 1
 * Входные данные:
 * Анна,Математика,85;Анна,Химия,90;Борис,Математика,75;Борис,История,80;Евгений,Математика,95;Евгений,История,85
 * Математика,80
 * Выходные данные:
 *
 * Евгений,95
 * Анна,85
 * Пример 2
 * Входные данные:
 * Анна,Психология,8;Алексей,Психология,6
 * Психология,9
 * Выходные данные:
 *
 * Никто
 * Решение:
 * Разбиение данных: Разделить первую строку по ; для получения информации о каждом студенте.
 * Извлечение условий: Разделить вторую строку для получения предмета и проходного балла.
 * Фильтрация студентов: Оставить только тех, кто соответствует предмету и набрал больше проходного балла.
 * Сортировка: Студенты сортируются по убыванию баллов. Если баллы равны, сохраняется порядок ввода.
 * Форматирование результата: Имена и баллы студентов выводятся с новой строки. Если подходящих студентов нет, выводится "Никто".
 */
public class LC_ElectronicDiary {

    public static void main(String[] args) {
        // Пример 1
        String studentData1 = "Анна,Математика,85;Анна,Химия,90;Борис,Математика,75;Борис,История,80;Евгений,Математика,95;Евгений,История,85";
        String courseInfo1 = "Математика,80";
        System.out.println(getStudentRating(studentData1, courseInfo1));

        // Пример 2
        String studentData2 = "Анна,Психология,8;Алексей,Психология,6";
        String courseInfo2 = "Психология,8";
        System.out.println(getStudentRating(studentData2, courseInfo2));

        // Пример 3
        String studentData3 = "Мария,Математика,85;Мария,Химия,90;Петр,Математика,75;Петр,История,80;Ольга,Математика,95;Ольга,История,85";
        String courseInfo3 = "Химия,40";
        System.out.println(getStudentRating(studentData3, courseInfo3));
    }

    public static String getStudentRating(String studentData, String courseInfo) {
        String[] studentsParsed = studentData.split(";");
        List<Student> students = new ArrayList<>();
        Student student = null;
        for (String studentParsed : studentsParsed) {
            String[] studentInfos = studentParsed.split(",");
            student = new Student();
            student.name = studentInfos[0];
            student.subject = studentInfos[1];
            student.score = Integer.parseInt(studentInfos[2]);

            String[] filters = courseInfo.split(",");
            String filterSubject = filters[0];
            int filterLowerScore = Integer.parseInt(filters[1]);

            if (!filterSubject.equals(student.subject) || student.score < filterLowerScore) {
                continue;
            }

            students.add(student);
        }

        if (students.isEmpty()) return "Никто";
        students.sort((v1,v2) -> v2.score.compareTo(v1.score));

        StringJoiner sj = new StringJoiner("\n");
        students.forEach(value -> sj.add(String.format("%s,%s", value.name, value.score)));
        return sj.toString();
    }

    static class Student {

        private String name;
        private String subject;
        private Integer score;
    }
}
