package StreamsAndLambdas;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BigData {

    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender) {}
    public static void main(String[] args) {

        try {
            long startTime = System.currentTimeMillis();
         //  Map<String, String> result =
            Map<Boolean, Map<String, Long>> result =
                   Files.lines(Path.of("/Users/tamaratsymbaliuk/Downloads/Hr5m.csv")).parallel()
                    .skip(1)// header row
                    .limit(10)
                    .map(s -> s.split(",")) //splitting stream of strings into arrays
                    .map(a -> new Person(a[2], a[4], new BigDecimal(a[25]),a[32], a[5].strip().charAt(0)))
                           .collect(partitioningBy(p -> p.gender() == 'F',
                                   groupingBy(Person::state, counting())));
       //             .collect(summingLong(Person::salary));
                    /*
                           .collect(
                            groupingBy(Person::state, TreeMap::new,
                            groupingBy(Person::gender,
                                    collectingAndThen(
                                            reducing(BigDecimal.ZERO, Person::salary,(a, b) -> a.add(b)),
                                            NumberFormat.getCurrencyInstance()::format))));
                                            */

                   // using TreeMap is not necessary, using to have result alphabetize

                          // .forEach((state, salary) -> System.out.printf("%s -> %s%n", state, salary));

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
