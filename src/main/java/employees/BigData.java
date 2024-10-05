package employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class BigData {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            Long result = Files.lines(Path.of("/Users/tamaratsymbaliuk/Downloads/Hr5m.csv")).parallel()
                    .skip(1)// header row
                    .limit(10)
                    .map(s -> s.split(",")) //splitting stream of strings into arrays
                    .map(arr -> arr[25]) // getting column 25 from the array
                    .mapToLong(sal -> Long.parseLong(sal))
                    .sum();
//                    .collect(Collectors.summingLong(sal -> Long.parseLong(sal)));
            long endTime = System.currentTimeMillis();
            System.out.printf("$%,d.00%n", result);
            System.out.println(endTime - startTime);
                 //   .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
