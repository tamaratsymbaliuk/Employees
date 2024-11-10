package StreamsAndLambdas;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateCounter {
    public static void main(String[] args) throws IOException {
        Map<String, Long> stateCounts = new HashMap<>();
        Files.lines(Path.of("/Users/tamaratsymbaliuk/Downloads/Hr5m.csv"))
                .skip(1)
                .map(l-> l.split(","))
                .forEach(a-> stateCounts.compute(a[32], (k, v) -> v == null ? 1L : v + 1));
        System.out.println(stateCounts);

        // this line (k, v) -> v == null ? 1L : v + 1)) is same as

        Long curPopulation = stateCounts.get("CA");
        if (curPopulation == null) {
            stateCounts.put("CA", 1L);
        } else {
            stateCounts.put("CA", ++curPopulation);
        }

        List.of("cat", "dog").replaceAll(s -> s.toUpperCase());
        List.of("cat", "dog").removeIf(w-> w.startsWith("c"));

    }
}
