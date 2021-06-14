package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPeople {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Maria", 23),
                new Person("Pesho", 44),
                new Person("Gosho", 18),
                new Person("Alexandra", 56));

        Collections.sort(people,
                Comparator.comparing(Person::getName));

        System.out.println(people.toString());
    }
}
