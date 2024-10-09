package employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BigData {

    record Person(String firstName, String lastName, long salary, String state) {}
    public static void main(String[] args) {

        try {
            long startTime = System.currentTimeMillis();
           Map<String, String> result = Files.lines(Path.of("/Users/tamaratsymbaliuk/Downloads/Hr5m.csv")).parallel()
                    .skip(1)// header row
                    .limit(10)
                    .map(s -> s.split(",")) //splitting stream of strings into arrays
                    .map(a -> new Person(a[2], a[4], Long.parseLong(a[25]),a[32]))
       //             .collect(summingLong(Person::salary));
                    .collect(groupingBy(Person::state, TreeMap::new,
                            collectingAndThen(summingLong(Person::salary), s -> String.format("$%,d.00%n", s)))); // using TreeMap is not necessary, using to have result alphabetize
            long endTime = System.currentTimeMillis();
      //      System.out.printf("$%,d.00%n", result);
            System.out.println(result);
            System.out.println(endTime - startTime);
                 //   .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
