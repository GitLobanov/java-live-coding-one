package by.lobanov.training.demos.demo1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D1_ComparatorAndComparable {

    /**
     * <a href="https://www.scaler.com/topics/java/comparable-and-comparator-in-java/">Comparable and Comparator in Java</a>
     */
    public static void main(String[] args) {
        List<SuperHero> superHeroes = new ArrayList<>();

        superHeroes.add(new SuperHero("2", "Iron Man", 35));
        superHeroes.add(new SuperHero("1", "Captain America", 25));
        superHeroes.add(new SuperHero("3", "Hulk", 20));

        Collections.sort(superHeroes);
        superHeroes.forEach(System.out::println);

        sortByAge(superHeroes);
        superHeroes.forEach(System.out::println);

        superHeroes.sort(Comparator.comparing(SuperHero::getName));
        superHeroes.sort(comparatorSortByName(superHeroes));
    }

    @Data
    public static class SuperHero implements Comparable<SuperHero> {

        private final String id;
        private final String name;
        private final int age;

        @Override
        public int compareTo(SuperHero o) {
            return id.compareTo(o.id);
        }
    }

    public static void sortByAge(List<SuperHero> superHeroes) {
        Comparator<SuperHero> ageComparator = (SuperHero s1, SuperHero s2) ->
        {
            return s1.getAge() - s2.getAge();
        };

        superHeroes.sort(ageComparator);
    }

    public static Comparator<SuperHero> comparatorSortByName (List<SuperHero> superHeroes) {
        return (SuperHero s1, SuperHero s2) ->
        {
            return s1.getName().compareTo(s2.getName());
        };

    }

    public static Comparator<SuperHero> comparatorLightSortByName (List<SuperHero> superHeroes) {
        return Comparator.comparing(SuperHero::getName);
    }


}
