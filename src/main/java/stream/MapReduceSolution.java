package stream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by david on 3/22/17.
 */
public class MapReduceSolution {
    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 100).reduce((sum, a) -> sum + a).getAsInt();
        System.out.println(total);

        total = IntStream.rangeClosed(1, 100).reduce(5, (sum, a) -> sum + a);
        System.out.println(total);

        String s = IntStream.rangeClosed(1, 10).mapToObj(i -> "test" + i).collect(Collectors.joining(", "));
        System.out.println(s);

        Person[] persons = {new Person("abby", "barnes", 33),
                new Person("chris", "barnes", 41),
                new Person("ed", "samuels", 44),
                new Person("mary", "macdonald", 70)};

        Stream.of(persons).map(p -> p.getLastName() + ", " + p.getFirstName()).forEach(System.out::println);

        System.out.println(IntStream.range(1, 4).map(i -> 2*i+1).average().getAsDouble());

        System.out.println(Stream.of("max", "leo").collect(Collectors.joining(" and ", "I am ", " the destroyer")));

        Random random = new Random();
        random.ints(0, 10).limit(10).forEach(System.out::println);
        random.ints().limit(10).forEach(System.out::println);
    }
}
