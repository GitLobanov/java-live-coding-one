package by.lobanov.training.demos.demo7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC9 {

    public static void main(String[] args) {


//        String number = "1234567890";
//        String [] numbers = number.split("");
//        String numberMasked = Arrays.stream(numbers)
//                .skip(6)
//                .reduce("******", (n1,n2) -> n1+n2);
//        System.out.println(numberMasked);

//        Разделите сотрудников на группы по возрастным категориям (например, до 30 лет, от 30
//        до 40 лет, старше 40 лет) и выведите количество сотрудников в каждой категории.

        List<Employee> list =  Arrays.asList(
                new Employee("Иван Иванов", 28, 50000),
                new Employee("Петр Петров", 35, 70000),
                new Employee("Сергей Сергеев", 40, 65000),
                new Employee("Анна Аннова", 25, 45000),
                new Employee("Мария Мариева", 32, 60000),
                new Employee("Алексей Алексеев", 45, 80000)
        );

        list.stream()
                .collect(Collectors.groupingBy(e ->
                        e.getAge() < 30 ? "до 30 лет" :
                                e.getAge() <= 40 ? "от 30 до 40" : "старше 40", Collectors.counting()));
    }



    static class Employee {
        private String name;
        private int age;
        private double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }


    }
    }
