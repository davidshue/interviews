package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by david on 3/22/17.
 */
public class SortingSolution {
    public static void main(String[] args) {
        List<Integer> sortedI = Stream.of(2,5, 3, 6).sorted().collect(Collectors.toList());
        System.out.println(sortedI);

        int[] sortedIArray = IntStream.of(2,5,3,6).sorted().toArray();
        System.out.println(Arrays.toString(sortedIArray));

        System.out.println(IntStream.of(2,5,3,6).sum());

        System.out.println(Arrays.toString(IntStream.of(2,5,3,6,3).distinct().toArray()));

        List<String> sortedS = Stream.of("john", "abby", "zoe", "cloe", "matt").sorted().collect(Collectors.toList());
        System.out.println(sortedS);

        Person[] persons = {new Person("abby", "barnes", 33),
                new Person("chris", "barnes", 38),
                new Person("ed", "samuels", 44),
                new Person("mary", "macdonald", 70)};

        List<Person> sortedP = Stream.of(persons)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        System.out.println(sortedP);

        Person oldest = Stream.of(persons)
                .max(Comparator.comparingInt(Person::getAge)).get();
        System.out.println(oldest);

        Person youngest = Stream.of(persons)
                .min(Comparator.comparingInt(Person::getAge)).get();
        System.out.println(youngest);


    }
}
