package exercises;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Ex1 { // Write code that allows you to model and store a collection of at least 5 cars and keeps
    //them in the order in which they were entered. Print them out to the screen also.
    record Car(String make, String model, Year year) {
    }

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mercedes","G-Class SUV", Year.of(2024)));
        cars.add(new Car("Tesla", "Y", Year.of(2017)));

        for(Car car : cars) {
            System.out.println(car);
        }
    }
}
