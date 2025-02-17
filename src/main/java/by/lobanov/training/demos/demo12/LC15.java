package by.lobanov.training.demos.demo12;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


/*
Задача: Валидация скобочных последовательностей
Дана строка, содержащая только символы '(', ')', '{', '}', '[' и ']'.
Определите, является ли входная строка валидной.

Правила валидности:
1. Открытые скобки должны закрываться скобками того же типа.
2. Открытые скобки должны закрываться в правильном порядке.
3. Каждая закрывающая скобка должна иметь соответствующую открывающую.

Примеры:
Вход: "()[]{}" → true
Вход: "([)]"   → false
Вход: "{[]}"   → true
*/
@Slf4j
public class LC15 {

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("([)]"));   // false
        System.out.println(isValid("{[]}"));   // true
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                deque.add(array[i]);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                if (!deque.removeLast().equals(map.get(array[i]))) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
