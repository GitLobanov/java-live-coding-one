package by.lobanov.training.demos.demo3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lc4 {

    static class Client {

        String name;
        Integer age;
        List<Phone> phones;

        public Client(String name, Integer age, List<Phone> phones) {
            this.name = name;
            this.age = age;
            this.phones = phones;
        }
    }

    static class Phone {

        Integer number;
        PhoneType type;

        public Phone(Integer number, PhoneType type) {
            this.number = number;
            this.type = type;
        }

        enum PhoneType {
            STATIONARY,
            MOBIL
        }
    }

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        clients.add(new Client("Joe", 15,
                List.of(new Phone(100, Phone.PhoneType.MOBIL))));
        clients.add(new Client("Mary", 25,
                List.of(new Phone(200, Phone.PhoneType.MOBIL), new Phone(201, Phone.PhoneType.MOBIL))));
        clients.add(new Client("Frank", 54,
                List.of(new Phone(301, Phone.PhoneType.MOBIL), new Phone(300, Phone.PhoneType.STATIONARY))));
        clients.add(new Client("Billy", 46,
                List.of(new Phone(400, Phone.PhoneType.STATIONARY))));
        clients.add(new Client("Stefan", 35,
                List.of(new Phone(500, Phone.PhoneType.MOBIL), new Phone(501, Phone.PhoneType.MOBIL))));
        clients.add(new Client("Rose", 46,
                List.of(new Phone(600, Phone.PhoneType.STATIONARY), new Phone(601, Phone.PhoneType.MOBIL))));

        clients.stream()
                .filter(client ->
                        client.phones.stream().anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY)))
                .max(Comparator.comparingInt(client -> client.age))
                .ifPresent(System.out::println);
    }

}
