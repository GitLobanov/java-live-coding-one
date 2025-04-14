package by.lobanov.training.ru.review.streamapi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiPerson {

    public static void main(String[] args) {

        Set<Person> persons = new HashSet<>();

        persons.add(new Person("alex", "2"));
        persons.add(new Person("sergei", "3"));
        persons.add(new Person("alex", "4"));

        var streamPerson = persons.stream();
        System.out.println(streamPerson
                .map(Person::getName)
                .collect(Collectors.joining(", "))
        );

        System.out.println(streamPerson
                .map(Person::getAge)
                .collect(Collectors.toList())
        );

    }

    public static class Person {
        private final String name;
        private final String age;

        public Person(String name, String age) {
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Person person = (Person) object;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}
