package by.lobanov.training.demos.demo6.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

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
     * 1. Получить список уникальных комнат
     */
    public List<String> getUniqueRooms() {
        return devices.stream()
                .map(device -> device.room)
                .distinct()
                .toList();
    }

    /**
     * 2. Посчитать общее потребление энергии для всех активных устройств.
     */
    public int getTotalActivePowerUsage() {
        return devices.stream()
                .filter(device -> device.isActive)
                .mapToInt(device -> device.powerUsage)
                .sum();
    }

    /**
     * 3. Найти устройство с минимальным потреблением энергии среди активных устройств.
     */
    public Optional<Device> getDeviceWithMinPowerUsage() {
        return devices.stream().min(Comparator.comparingInt(device -> device.powerUsage));
    }

    /**
     * 4. Создать карту, где ключ — название комнаты, а значение — список устройств в этой комнате.
     */
    public Map<String, List<Device>> getDevicesByRoom() {
        return devices.stream()
                .collect(Collectors.groupingBy(device -> device.room));
    }

    /**
     * 5. Разделить устройства на две группы: активные (true) и неактивные (false).
     */
    public Map<Boolean, List<String>> partitionDevicesByActivity() {
        return devices.stream()
                .collect(Collectors.partitioningBy(
                        Device::isActive,
                        Collectors.mapping(Device::getName, Collectors.toList())
                ));
    }

    /**
     * 6. Подсчитать количество устройств в каждой комнате.
     */
    public Map<String, Long> getDeviceCountByRoom() {
        return devices.stream()
                .collect(Collectors.groupingBy(Device::getRoom, Collectors.counting()));
    }

    /**
     * 7. Найти топ-3 устройства с наибольшим потреблением энергии.
     */
    public List<Device> getTop3PowerConsumingDevices() {
        return devices.stream()
                .sorted(Comparator.comparingInt((Device device) -> device.powerUsage).reversed())
                .limit(3)
                .toList();
    }

    /**
     * 8. Получить список комнат, отсортированный по суммарному потреблению энергии устройств в них.
     * Условие: Использовать `collectingAndThen`
     */
    public List<String> getRoomsSortedByPowerUsage() {
        return devices.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        device -> device.room,
                                        Collectors.summingInt(device -> device.powerUsage)
                                ),
                                map -> map.entrySet().stream()
                                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
                                        .map(Map.Entry::getKey)
                                        .toList()
                        )
                );
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
        System.out.println("Список уникальных комнат: " + smartHome.getUniqueRooms()); // [Living Room, Kitchen, Office, Bedroom]
        System.out.println("Общее потребление энергии для всех активных устройств" + smartHome.getTotalActivePowerUsage()); // 770
        System.out.println("Устройство с минимальным потреблением энергии среди активных устройств" + smartHome.getDeviceWithMinPowerUsage().get().getName()); // Lamp
        System.out.println("" + smartHome.getDevicesByRoom()); // {Living Room=[TV, Heater], Kitchen=[Fridge, Microwave], ...}
        System.out.println("Активные и неактивные устройства: " + smartHome.partitionDevicesByActivity()); // {true=[TV, Fridge, Heater, Microwave], false=[Laptop, Lamp]}
        System.out.println("Количество устройств в каждой комнате: " + smartHome.getDeviceCountByRoom()); // {Living Room=2, Kitchen=2, Office=1, Bedroom=1}
        System.out.println("Топ 3 самых прожорливых устройства: " + smartHome.getTop3PowerConsumingDevices()); // [Heater, Fridge, TV]
        System.out.println("" + smartHome.getRoomsSortedByPowerUsage()); // [Living Room, Kitchen, Office, Bedroom]
        System.out.println("" + smartHome.getPowerUsageStatistics()); // count=6, sum=920, min=50, average=153.33, max=300
        System.out.println("" + smartHome.hasDeviceWithPowerUsageAbove(250)); // true
    }
}
