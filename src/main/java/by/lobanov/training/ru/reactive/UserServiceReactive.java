package by.lobanov.training.ru.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserServiceReactive {

    public static void main(String[] args) {
        UserServiceReactive userService = new UserServiceReactive();

        // Тест 1: Получить всех пользователей
        System.out.println("All Users:");
        userService.getUsers()
                .doOnNext(user -> System.out.println(user.getName() + " - " + user.getAge()))
                .subscribe();

        // Тест 2: Получить пользователей старше 18 лет
        System.out.println("\nAdult Users:");
        userService.getAdultUserNames()
                .doOnNext(System.out::println)
                .subscribe();

        // Тест 3: Применить скидку к возрасту
        System.out.println("\nUsers with age discount:");
        userService.applyAgeDiscount()
                .doOnNext(System.out::println)
                .subscribe();

        // Тест 4: Обработка ошибки при отрицательном возрасте
        System.out.println("\nHandling Negative Age:");
        userService.handleNegativeAge()
                .doOnNext(System.out::println)
                .subscribe();

        // Тест 5: Получить пользователя по имени
        System.out.println("\nGet User by Name:");
        userService.getUserByName("Mike")
                .doOnNext(System.out::println)
                .subscribe();
    }

    // Тестовые данные - Список пользователей
    public Flux<User> getUsers() {
        return Flux.just(
                new User("John", 20),
                new User("Sarah", 16),
                new User("Mike", 25),
                new User("Anna", 15)
        );
    }

    // 1. Метод для фильтрации пользователей старше 18 лет
    public Flux<String> getAdultUserNames() {
        // TODO: Реализуй логику здесь
        return getUsers()
                .filter(user -> user.age > 18)
                .map(User::getName)
                .switchIfEmpty(Flux.just("No adult users found"));
    }

    // 2. Метод для применения скидки к возрасту пользователя
    public Flux<String> applyAgeDiscount() {
        // TODO: Реализуй логику здесь
        return null;  // Пока пусто
    }

    // 3. Метод для обработки ошибки, если возраст < 0
    public Flux<String> handleNegativeAge() {
        // TODO: Реализуй логику здесь
        return null;  // Пока пусто
    }

    // 4. Метод для получения пользователя по имени
    public Mono<String> getUserByName(String name) {
        // TODO: Реализуй логику здесь
        return null;  // Пока пусто
    }

    // Класс User
    class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public User setAge(int age) {
            this.age = age;
            return this;
        }
    }
}
