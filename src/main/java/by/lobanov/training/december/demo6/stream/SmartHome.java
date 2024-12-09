package by.lobanov.training.december.demo6.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class SmartHome {
    private List<Device> devices; // Устройства в умном доме

    // Устройство
    @Data
    @AllArgsConstructor
    public static class Device {
        private String name;       // Название устройства
        private String room;       // Комната, где находится устройство
        private boolean isActive;  // Включено ли устройство
        private int powerUsage;    // Потребление энергии (Вт)
    }

    public SmartHome(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * 1. Получить список уникальных комнат, где есть хотя бы одно устройство.
     * Условие: Использовать Stream API, метод `map` и `distinct`.
     */
    public List<String> getUniqueRooms() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 2. Посчитать общее потребление энергии для всех активных устройств.
     * Условие: Использовать Stream API и метод `filter` + `mapToInt`.
     */
    public int getTotalActivePowerUsage() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 3. Найти устройство с минимальным потреблением энергии среди активных устройств.
     * Условие: Использовать Stream API и метод `min`.
     */
    public Optional<Device> getDeviceWithMinPowerUsage() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 4. Создать карту, где ключ — название комнаты, а значение — список устройств в этой комнате.
     * Условие: Использовать Stream API и метод `groupingBy`.
     */
    public Map<String, List<Device>> getDevicesByRoom() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 5. Разделить устройства на две группы: активные и неактивные.
     * Условие: Использовать Stream API и метод `partitioningBy`.
     */
    public Map<Boolean, List<Device>> partitionDevicesByActivity() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 6. Подсчитать количество устройств в каждой комнате.
     * Условие: Использовать Stream API и метод `groupingBy` + `counting`.
     */
    public Map<String, Long> getDeviceCountByRoom() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 7. Найти топ-3 устройства с наибольшим потреблением энергии.
     * Условие: Использовать Stream API и метод `sorted` + `limit`.
     */
    public List<Device> getTop3PowerConsumingDevices() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 8. Получить список комнат, отсортированный по суммарному потреблению энергии устройств в них.
     * Условие: Использовать Stream API, `groupingBy`, `collectingAndThen`, и сортировку.
     */
    public List<String> getRoomsSortedByPowerUsage() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 9. Вывести статистику потребления энергии по всем устройствам (количество, среднее, максимум, минимум).
     * Условие: Использовать Stream API и метод `summaryStatistics`.
     */
    public IntSummaryStatistics getPowerUsageStatistics() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * 10. Проверить, есть ли хотя бы одно устройство с потреблением энергии выше указанного значения.
     * Условие: Использовать Stream API и метод `anyMatch`.
     */
    public boolean hasDeviceWithPowerUsageAbove(int threshold) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    public static void main(String[] args) {
        List<SmartHome.Device> devices = Arrays.asList(
                new SmartHome.Device("TV", "Living Room", true, 150),
                new SmartHome.Device("Fridge", "Kitchen", true, 200),
                new SmartHome.Device("Laptop", "Office", false, 100),
                new SmartHome.Device("Heater", "Living Room", true, 300),
                new SmartHome.Device("Lamp", "Bedroom", false, 50),
                new SmartHome.Device("Microwave", "Kitchen", true, 120)
        );

        SmartHome smartHome = new SmartHome(devices);

        // Примеры задач
        System.out.println(smartHome.getUniqueRooms()); // [Living Room, Kitchen, Office, Bedroom]
        System.out.println(smartHome.getTotalActivePowerUsage()); // 770
        System.out.println(smartHome.getDeviceWithMinPowerUsage().get().getName()); // Microwave
        System.out.println(smartHome.getDevicesByRoom()); // {Living Room=[TV, Heater], Kitchen=[Fridge, Microwave], ...}
        System.out.println(smartHome.partitionDevicesByActivity()); // {true=[TV, Fridge, Heater, Microwave], false=[Laptop, Lamp]}
        System.out.println(smartHome.getDeviceCountByRoom()); // {Living Room=2, Kitchen=2, Office=1, Bedroom=1}
        System.out.println(smartHome.getTop3PowerConsumingDevices()); // [Heater, Fridge, TV]
        System.out.println(smartHome.getRoomsSortedByPowerUsage()); // [Living Room, Kitchen, Office, Bedroom]
        System.out.println(smartHome.getPowerUsageStatistics()); // count=6, sum=920, min=50, average=153.33, max=300
        System.out.println(smartHome.hasDeviceWithPowerUsageAbove(250)); // true
    }
}
