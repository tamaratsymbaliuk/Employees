package exercises;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Ex2 { //Same as exercise 1 except we don’t care about retaining the order and we want to ensure
    //that duplicates will not exist.
record Car(String make, String model, Year year){}
    public static void main(String[] args) {
        Set<Ex1.Car> cars = new HashSet<>();
        cars.add(new Ex1.Car("Mercedes","G-Class SUV", Year.of(2024)));
        cars.add(new Ex1.Car("Tesla", "Y", Year.of(2017)));

        for(Ex1.Car car : cars) {
            System.out.println(car);
        }
    }
}
