package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by david on 3/22/17.
 */
public class GroupingSolution {
    public static void main(String[] args) {
        Person[] persons = {new Person("abby", "barnes", 33),
                new Person("chris", "barnes", 41),
                new Person("ed", "samuels", 44),
                new Person("mary", "macdonald", 70)};

        Map<String, List<Person>> byLastName = Stream.of(persons).collect(Collectors.groupingBy(Person::getLastName));

        System.out.println(byLastName);

        Map<String, Long> numByLastName = Stream.of(persons).collect(Collectors.groupingBy(Person::getLastName, Collectors.counting()));
        System.out.println(numByLastName);

        Map<Boolean, List<Person>> ageGroup = Stream.of(persons).collect(Collectors.partitioningBy(p -> p.getAge() < 40));
        System.out.println(ageGroup);

        Map<String, Map<String, List<Person>>> lastNameAge = Stream.of(persons).collect(Collectors.groupingBy(
                Person::getLastName,
                Collectors.groupingBy(
                        p -> p.getAge() < 40 ? "Junior": "Senior"
                )
        ));

        System.out.println(lastNameAge);

        String[] languages = {"Java", "Scala", "Groovy", "Python", "C-Sharp", "Swift", "Go", "Erlang"};
        String together = Stream.of(languages).sorted().collect(Collectors.joining(", "));
        System.out.println(together);

        long start = System.currentTimeMillis();
        Map<String, List<Integer>> factored = IntStream.rangeClosed(1, 100000).parallel().mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.groupingBy(i -> i.intValue() % 3 == 0 ? "3_FACTOR": "N3_FACTOR"));
        long end = System.currentTimeMillis();

        System.out.println("took " + (end-start) + " ms");
    }
}
