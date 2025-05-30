package by.lobanov.training.ru.livecoding.bycompany.hhru.heavy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Вы работаете над внутрикорпоративной системой доступа пользователей. Реализуйте класс UserManager, который будет управлять доступом пользователей к системе.
 *
 * У класса должны быть методы для добавления нового пользователя, удаления пользователя, повышения и понижения уровня доступа пользователя,
 * а также для получения списка всех пользователей. Уровни доступа пользователей – это целые числа (0 ≤ x).
 *
 * Класс UserManager должен поддерживать следующие методы, которые должны быть цепочками (кроме get_users):
 *
 * add_user – добавляет нового пользователя с указанным уровнем доступа или уровнем доступа по умолчанию, равным 1;
 * remove_user – удаляет пользователя;
 * promote – увеличивает уровень доступа пользователя на 1;
 * demote – уменьшает уровень доступа на 1, если уровень доступа больше 0. Иначе ничего не происходит.
 * get_users – вернет список всех пользователей с их текущим уровнем доступа.
 * Формат ввода
 * Несколько строк, состоящих из команд add_user, remove_user, promote, demote, get_users.
 * Входные данные гарантированно завершаются командой get_users.
 *
 * Формат вывода
 * Несколько строк, в которой может быть один из вариантов:
 *
 * Пользователи с уровнем доступа, при этом исходный порядок пользователей сохраняется;
 * «Не найдено», если пользователей в списке не осталось.
 * 
 * Пример 1
 * Входные данные:
 * add_user Alice 4
 * add_user Bob 3
 * add_user Charlie 2
 * get_users
 * 
 * Выходные данные:
 * Alice: 4
 * Bob: 3
 * Charlie: 2
 * Пример 2
 * 
 * Входные данные:
 * add_user Alice 1
 * add_user Bob 3
 * add_user Charlie 3
 * promote Alice
 * promote Alice
 * demote Alice
 * get_users
 * 
 * Выходные данные:
 * Alice: 2
 * Bob: 3
 * Charlie: 3
 * 
 * Пример 3
 * Входные данные:
 *
 * add_user Bob 3
 * add_user Charlie 2
 * remove_user Bob
 * remove_user Charlie
 * get_users
 * Выходные данные:
 *
 * Не найдено
 */
public class LC_UserManager {

    public static void main(String[] args) {
        // Тест 1
        String[] commands1 = {
                "add_user Alice 4",
                "add_user Bob 3",
                "add_user Charlie 2",
                "get_users"
        };

        processCommands(commands1);

        // Тест 2
        String[] commands2 = {
                "add_user Alice 1",
                "add_user Bob 3",
                "add_user Charlie 3",
                "promote Alice",
                "promote Alice",
                "demote Alice",
                "get_users"
        };

        processCommands(commands2);
    }

    private static void processCommands (String [] commands) {
        for (String command : commands) {
            String output = processInput(command);
            if (output != null) {
                System.out.println(output);
            }
        }
    }

    private static final Map<String, UnaryOperator<String>> commands = new HashMap<>();
    private static final Map<String, Integer> users = new LinkedHashMap<>();

    static {
        final UnaryOperator<String> addFunction = input -> {
            String[] user =  input.split(" ");
            if (user.length > 2) {
                users.put(user[1], Integer.parseInt(user[2]));
            } else {
                users.put(user[1], 1);
            }
            return null;
        };

        commands.put("add_user", addFunction);

        final UnaryOperator<String> getUsers = input -> {
            if (users.isEmpty()) return "Не найдено";
            StringJoiner sj = new StringJoiner("\n");
            users.forEach((key, value) -> sj.add(String.format("%s: %s", key, value)));
            return sj.toString();
        };

        commands.put("get_users", getUsers);

        final UnaryOperator<String> removeUser = input -> {
            String[] user =  input.split(" ");
            users.remove(user[1]);
            return null;
        };

        commands.put("remove_user", removeUser);

        final UnaryOperator<String> promote = input -> {
            String[] user =  input.split(" ");
            users.computeIfPresent(user[1], (name, access) -> access + 1);
            return null;
        };

        commands.put("promote", promote);

        final UnaryOperator<String> demote = input -> {
            String[] user =  input.split(" ");
            users.computeIfPresent(user[1], (name, access) -> {
                int newAccess = access - 1;
                if (newAccess < 1) {
                    return access;
                }
                return newAccess;
            });
            return null;
        };

        commands.put("demote", demote);
    }

    public static String processInput (String command) {
        String keyCommand = command.split(" ")[0];
        return commands.get(keyCommand).apply(command);
    }
}
