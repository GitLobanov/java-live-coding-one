package by.lobanov.training.ru.core.livecoding;

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
public class LC_ru_ValidateBrackets {

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    public static void main(String[] args) {
        System.out.println(isValidDeque("()[]{}")); // true
        System.out.println(isValidDeque("([)]"));   // false
        System.out.println(isValidDeque("{[]}"));   // true

        System.out.println(isValidStack("()[]{}")); // true
        System.out.println(isValidStack("([)]"));   // false
        System.out.println(isValidStack("{[]}"));   // true
    }

    public static boolean isValidStack (String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char bracket = map.get(c);
                if (!stack.pop().equals(bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidDeque(String s) {
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
