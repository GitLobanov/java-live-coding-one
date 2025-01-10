package by.lobanov.training.demos.demo6.stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;

public class MobilePhone {

    private List<App> apps;               // Список установленных приложений
    private List<Call> callHistory;       // История вызовов
    private List<Contact> contacts;       // Список контактов

    // Приложение
    @Data
    @RequiredArgsConstructor
    public static class App {
        private final String name;
        private final double size;        // Размер в мегабайтах
        private final boolean isSystem;   // Системное ли приложение
    }

    // Вызов
    @Data
    @RequiredArgsConstructor
    public static class Call {
        private final String number;
        private final int duration;       // Длительность в секундах
        private final boolean isMissed;   // Пропущен ли вызов
    }


    // Контакт
    @Data
    @RequiredArgsConstructor
    public static class Contact {
        private final String name;
        private final String phoneNumber;
    }

    public MobilePhone(List<App> apps, List<Call> callHistory, List<Contact> contacts) {
        this.apps = apps;
        this.callHistory = callHistory;
        this.contacts = contacts;
    }

    /**
     * 1. Получить список имен всех установленных приложений (исключая системные).
     * Условие: Использовать Stream API и `filter` + `map`.
     */
    public List<String> getInstalledAppNames() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 2. Найти общее количество пропущенных вызовов.
     * Условие: Использовать Stream API и `filter` + `count`.
     */
    public long getMissedCallsCount() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 3. Найти самое большое приложение (по размеру).
     * Условие: Использовать Stream API и `max` с кастомным компаратором.
     */
    public Optional<App> getLargestApp() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 4. Создать отчет о вызовах в формате: "Имя контакта (если найден) или номер: длительность вызова".
     * Условие: Использовать Stream API, `map`, и `joining`.
     */
    public String getCallReport() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 5. Получить карту, где ключ - имя контакта, а значение - количество вызовов этому контакту.
     * Условие: Использовать `groupingBy` и `mapping` или `counting`.
     */
    public Map<String, Long> getCallCountByContact() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 6. Найти общую длительность всех вызовов (в минутах) с округлением вверх.
     * Условие: Использовать Stream API и `mapToInt` + `sum`.
     */
    public int getTotalCallDurationInMinutes() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 7. Составить список приложений, отсортированных по размеру, в порядке убывания.
     * Условие: Использовать Stream API и `sorted` с кастомным компаратором.
     */
    public List<App> getAppsSortedBySizeDesc() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 8. Найти контакт, который получил больше всего вызовов.
     * Условие: Использовать Stream API, `groupingBy`, `maxBy`, и `comparing`.
     */
    public Optional<Contact> getMostCalledContact() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 9. Разделить приложения на системные и пользовательские.
     * Условие: Использовать Stream API и `partitioningBy`.
     */
    public Map<Boolean, List<App>> partitionAppsBySystemStatus() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 10. Составить список всех уникальных номеров вызовов.
     * Условие: Использовать Stream API и `distinct`.
     */
    public List<String> getUniqueCallNumbers() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    public static void main(String[] args) {
        MobilePhone phone = getMobilePhone();

        System.out.println(phone.getInstalledAppNames()); // ["WhatsApp", "Instagram"]
        System.out.println(phone.getMissedCallsCount()); // 1
        System.out.println(phone.getLargestApp()); // Optional[System Update]
        System.out.println(phone.getCallReport()); // John Doe: 120, John Doe: 300, Jane Smith: 60
        System.out.println(phone.getCallCountByContact()); // {John Doe=2, Jane Smith=1}
        System.out.println(phone.getTotalCallDurationInMinutes()); // 8
        System.out.println(phone.getAppsSortedBySizeDesc()); // [System Update, Instagram, WhatsApp]
        System.out.println(phone.getMostCalledContact()); // Optional[John Doe]
        System.out.println(phone.partitionAppsBySystemStatus()); // {true=[System Update], false=[WhatsApp, Instagram]}
        System.out.println(phone.getUniqueCallNumbers()); // ["123-456-7890", "987-654-3210"]
    }

    private static MobilePhone getMobilePhone() {
        List<App> apps = Arrays.asList(
                new App("WhatsApp", 100.5, false),
                new App("System Update", 200.0, true),
                new App("Instagram", 150.0, false)
        );

        List<Call> calls = Arrays.asList(
                new Call("123-456-7890", 120, false),
                new Call("123-456-7890", 300, true),
                new Call("987-654-3210", 60, false)
        );

        List<Contact> contacts = Arrays.asList(
                new Contact("Bullied Miko", "123-456-7890"),
                new Contact("Shan Sai Dmitry", "987-654-3210")
        );

        MobilePhone phone = new MobilePhone(apps, calls, contacts);
        return phone;
    }
}
