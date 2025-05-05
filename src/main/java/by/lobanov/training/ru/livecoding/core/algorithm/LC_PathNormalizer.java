package by.lobanov.training.ru.livecoding.core.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class LC_PathNormalizer {

    // Перемещение по каталогам в терминале (команда сd)
    // Необходимо "нормализировать" введенный путь, избавившись от . и .., приведя путь к конечному (команда pwd)
    // input: "/usr/local/bin"
    // output: "/usr/local/bin"
    // input: "/usr/local/././lib"
    // output: "/usr/local/lib"
    // input: "/usr/local/../bin"
    // output: "/usr/bin"
    // input: "/usr/../var/local/././lib/../../log"
    // output: "/var/log"
    public static void main(String[] args) {
        System.out.println(normalize("/usr/local/bin"));
        System.out.println(normalize("/usr/local/././lib"));
        System.out.println(normalize("/usr/local/../bin"));
        System.out.println(normalize("/usr/../var/local/././lib/../../log"));
    }

    public static String normalize(String path) {
        String [] parts = path.split("/");

        Deque<String> deque = new LinkedList();

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(".")) {
                continue;
            } else if (parts[i].equals("..")) {
                deque.removeLast();
            } else {
                deque.addLast(parts[i]);
            }
        }

        return String.join("/", deque);
    }
}
