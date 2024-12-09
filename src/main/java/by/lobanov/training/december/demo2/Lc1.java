package by.lobanov.training.december.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Lc1 {}

class Sale {

    String productName;
    String category;
    double price;
    int quantity;

    Sale(String productName, String category, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getTotalSale() {
        return price * quantity;
    }

    //
//### Задача: Анализ продаж
//**Условие:** Дано список объектов класса `Sale`, представляющего информацию о продажах.
// Каждый объект содержит данные о названии продукта, категории, цене и количестве. Напишите программу, которая:
//
//            1. Сгруппирует продажи по категории продукта и
//            для каждой категории вычислит общую сумму продаж (цена * количество).
//            2. Отфильтрует категории, у которых сумма продаж больше 100.
//            3. Отсортирует оставшиеся категории по общей сумме продаж в порядке убывания.
//            4. Выведет название категории и общую сумму продаж для оставшихся категорий.
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("Laptop", "Electronics", 1000, 1),
                new Sale("Smartphone", "Electronics", 500, 2),
                new Sale("Chair", "Furniture", 150, 5),
                new Sale("Desk", "Furniture", 300, 1),
                new Sale("Pen", "Stationery", 1, 100),
                new Sale("Notebook", "Stationery", 2, 50)
        );

        sales.stream()
                .collect(Collectors.groupingBy(sale -> sale.category, Collectors.summingDouble(sale -> sale.getTotalSale())))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 100)
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
//                .sorted()
                .forEach(System.out::println);

    }


}

@Data
@AllArgsConstructor
class Author {
    private String name;

    private List<Book> books;

    public static void main(String[] args) {
        Book jamesBond = new Book("James Bond", 2001);
        Book jamesBond2 = new Book("James Bond2", 2003);
        Book jamesBond3 = new Book("James Bond3", 2008);
        Book jamesBond4 = new Book("James Bond4", 2011);
        Author author1 = new Author("Ian Fleming", List.of(jamesBond, jamesBond2, jamesBond3, jamesBond4));

        Book garryPotter = new Book("Garry Potter", 2001);
        Book garryPotter2 = new Book("Garry Potter2", 2003);
        Book garryPotter3 = new Book("Garry Potter3", 2008);
        Book garryPotter4 = new Book("Garry Potter4", 2011);
        Author author2 = new Author("Joanne Rowling", List.of(garryPotter, garryPotter2, garryPotter3, garryPotter4));

        // вывести список названий книг авторов написанных после 2005
        Stream.of(author1, author2)
//                .map(author -> author.books)
                .flatMap(author -> author.books.stream())
                .filter(book -> book.getYear() > 2005)
                .map(book ->  book.getName())
                .forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class Book {
    private String name;
    private Integer year;
}

//

@Data
@AllArgsConstructor
class Client {
    Integer id;
    String name;
    Integer age;
    List<Phone> phones;

    public static void main(String[] args) {
        Phone phone1 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Phone phone2 = new Phone(321434L, Phone.PhoneType.STATIONARY);
        Phone phone3 = new Phone(4214L, Phone.PhoneType.MOBIL);
        Client firstClient = new Client(1, "first client", 25, List.of(phone1, phone2, phone3));
        Phone phone4 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Client secondClient = new Client(2, "second client", 48, List.of(phone4));
        Phone phone5 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Phone phone6 = new Phone(1234567L, Phone.PhoneType.STATIONARY);
        Client thirdClient = new Client(3, "third client", 48, List.of(phone5, phone6));

        //Найти самого возрастного клиента, которой пользуется стационарным телефоном
        List<Client> list = List.of(firstClient, secondClient, thirdClient);

        list.stream()
//                .flatMap(client -> client.phones.stream())
//                .filter(phone -> phone.type == Phone.PhoneType.STATIONARY)
                .filter(client ->
                        client.phones.stream().anyMatch(phone -> phone.type == Phone.PhoneType.STATIONARY))
                .max(Comparator.comparing(client -> client.age))
                .ifPresent(System.out::println);
    }
}



@Data
@AllArgsConstructor
class Phone {
    Long number;
    PhoneType type;

    enum PhoneType {
        STATIONARY,
        MOBIL
    }
}

//

@AllArgsConstructor
@Data
class Student {
    private String name; // имя
    private int age; // возраст
    private double grade; // оценка (0-100)
    private String major; // специальность

    //1. Отфильтровать студентов, старше 18 лет.
    //2. Группировать студентов по специальности.
    //3. Найти среднюю оценку для каждой специальности.
    //4. Отсортировать специальности по средней оценке в порядке убывания.
    //5. Вернуть результат как `Map`, где ключом является специальность, а значением — средняя оценка.
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85, "Computer Science"),
                new Student("Bob", 17, 90, "Mathematics"),
                new Student("Charlie", 22, 70, "Computer Science"),
                new Student("Dave", 19, 60, "Mathematics"),
                new Student("Eve", 21, 95, "Physics"),
                new Student("Frank", 24, 80, "Physics")
        );

        Map<String,Double> studends = students.stream()
                .filter(student -> student.age > 18)
                .collect(Collectors.groupingBy(student -> student.major, Collectors.averagingDouble(student -> student.grade)))
                .entrySet().stream()
                .sorted(Comparator.comparing(st -> st.getValue(), Comparator.reverseOrder()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (aDouble, aDouble2) -> aDouble, LinkedHashMap::new));

//        System.out.println(studends);

        AtomicInteger count = new AtomicInteger(1);
        Map<String, String> collect = Stream.of("1", "2", "3", "1")
                .collect(Collectors.toMap(s -> s, s -> {
                            if (s.equals("1")) {
                                count.getAndIncrement();
                                return s + count.get();
                            }
                            return s;
                        },
                        (s1, s2) -> s2));

        System.out.println(collect);
    }

}

