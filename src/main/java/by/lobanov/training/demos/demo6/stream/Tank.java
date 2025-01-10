package by.lobanov.training.demos.demo6.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Tank {
    private String name; // Название танка
    private int armor;   // Уровень брони
    private int firepower; // Уровень огневой мощи
    private List<Shell> shells; // Список снарядов, которыми оснащен танк

    // Снаряды
    @Data
    @AllArgsConstructor
    public static class Shell {
        private String type; // Тип снаряда (например, "HE", "AP", "HEAT")
        private int damage;  // Урон от снаряда
    }

    /**
     * 1. Получить список типов снарядов (без дубликатов).
     */
    public List<String> getShellTypes() {
        return shells.stream()
                .map(shell -> shell.type)
                .distinct()
                .toList();
    }

    /**
     * 2. Подсчитать суммарный урон всех снарядов.
     */
    public int getTotalDamage() {
        return shells.stream()
                .mapToInt(n -> n.damage)
                .reduce(0, Integer::sum);
    }

    /**
     * 3. Найти снаряд с максимальным уроном.
     */
    public Optional<Shell> getMaxDamageShell() {
        return shells.stream()
                .max(Comparator.comparingInt(shell -> shell.damage));
    }

    /**
     * 4. Получить все снаряды, урон которых выше указанного значения.
     */
    public List<Shell> getHighDamageShells(int threshold) {
       return shells.stream()
               .filter(shell -> shell.damage > 100)
               .toList();
    }

    /**
     * 5. Проверить, есть ли среди снарядов снаряды определенного типа.
     */
    public boolean hasShellType(String type) {
        return  shells.stream()
                .anyMatch(shell -> shell.type.equals(type));
    }

    /**
     * 6. Вывести общий нанесенный урон по типам
     */
    public Map<String, Integer> groupShellsByType() {
        return shells.stream()
                .collect(Collectors.groupingBy(shell -> shell.type, Collectors.summingInt(shell -> shell.damage)));
    }

    /**
     * 7. Проверить, все ли снаряды имеют урон выше указанного значения.
     */
    public boolean areAllShellsAboveDamage(int threshold) {
        return shells.stream()
                .allMatch(shell -> shell.damage > threshold);
    }

    /**
     * 8. Найти средний урон всех снарядов.
     */
    public double getAverageDamage() {
        return shells.stream()
                .collect(Collectors.averagingDouble(Shell::getDamage));
    }

    /**
     * 9. Преобразовать список снарядов в ОДНУ строку формата:
     * "type1:damage1, type2:damage2, ..."
     */
    public String shellsToString() {
        return shells.stream()
                .map(shell -> shell.type + ":" + shell.damage)
                .collect(Collectors.joining(", "));
    }


    public static void main(String[] args) {
        List<Tank.Shell> shells = Arrays.asList(
                new Tank.Shell("HE", 100),
                new Tank.Shell("AP", 150),
                new Tank.Shell("HEAT", 200),
                new Tank.Shell("AP", 120),
                new Tank.Shell("HE", 80)
        );

        Tank tank = new Tank("Tiger", 200, 300, shells);

        // Примеры задач
        System.out.println("Список типов снарядов: " + tank.getShellTypes()); // ["HE", "AP", "HEAT"]
        System.out.println("Суммарный урон всех снарядов: " + tank.getTotalDamage()); // 650
        System.out.println("Снаряд с максимальным уроном: " + tank.getMaxDamageShell().get()); // HEAT
        System.out.println("Все снаряды, урон которых выше 100: " + tank.getHighDamageShells(100)); // [AP, HEAT, AP]
        System.out.println("Есть ли переданный тип снаряда: " + tank.hasShellType("AP")); // true
        System.out.println("Вывести общий нанесенный урон по типам: " + tank.groupShellsByType()); // {HE=[HE, HE], AP=[AP, AP], HEAT=[HEAT]}
        System.out.println("Все ли снаряды имеют урон выше указанного значения" + tank.areAllShellsAboveDamage(50)); // true
        System.out.println("Статистика по урону: " + tank.getAverageDamage()); // 130.0
        System.out.println("" + tank.shellsToString()); // "HE:100, AP:150, HEAT:200, AP:120, HE:80"
    }


}

