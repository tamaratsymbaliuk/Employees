package exercises;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Ex3 { // Same as exercise 1 but associate an owner’s first name with each car. Do not add owner’s
    //name to your car model class. Print out each owner with their car.
    record Car(String make, String model, Year year){}

    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        cars.put("Bob", new Car("Tesla", "S", Year.of(2014)));
        cars.put("Jenny", new Car("Tesla", "X", Year.of(2015)));
        cars.put("Sarah", new Car("Tesla", "3", Year.of(2016)));
        cars.put("John", new Car("Tesla", "Y", Year.of(2017)));
        cars.put("Srinath", new Car("Tesla", "Roadster", Year.of(2009)));

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            // '\t' for tab space between owner name & car details - you could use anything to separate
            System.out.printf("%s\t%s%n", entry.getKey(), entry.getValue());
        }
    }
}
