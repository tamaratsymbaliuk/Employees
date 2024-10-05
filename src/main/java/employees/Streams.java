package employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.Predicate.not;

public class Streams {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=4000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=5000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=6000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=7000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=8000,yoe=10,iq=140}
                Flinstone3, Fred3, 1/01/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                Flinstone4, Fred4, 1/01/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                Flinstone5, Fred5, 1/01/1900, Programmer, {locpd=5,yoe=10,iq=100}
                Rubble, Barney, 2/02/1905, Manager, {orgSize=300,dr=10}
                Rubble2, Barney2, 2/02/1905, Manager, {orgSize=100,dr=10}
                Rubble3, Barney3, 2/02/1905, Manager, {orgSize=300,dr=2}
                Rubble4, Barney4, 2/02/1905, Manager, {orgSize=200,dr=4}
                Rubble5, Barney5, 2/02/1905, Manager, {orgSize=500,dr=100}
                Flinstone, Wilma, 3/03/1910, Analyst, {projectCount=3}
                Flinstone2, Wilma, 3/03/1910, Analyst, {projectCount=4}
                Flinstone3, Wilma, 3/03/1910, Analyst, {projectCount=5}
                Flinstone4, Wilma, 3/03/1910, Analyst, {projectCount=6}
                Flinstone5, Wilma, 3/03/1910, Analyst, {projectCount=9}
                Rubble, Betty, 4/4/1915, CEO, {avgSrockPrice=300}
                """;

//        int sum = peopleText
//                .lines()
//                .filter(not(s -> s.contains("Programmerzzzz")))
//                .map(Employee::createEmployee)
//              //  .sorted((x,y) -> Integer.compare(x.getSalary(), y.getSalary()))
//                .map(e -> (Employee)e)
//             //   .filter(not(e -> e.getLastName().equals("N/A")))
//                .collect(Collectors.toSet()).stream()
//                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
//                .mapToInt(e -> {
//                    System.out.println(e);
//                    return e.getSalary();
//                })
//                .sum();
//
//        System.out.println(sum);

//        peopleText.lines()
//                .map(Employee::createEmployee)
//                .map(e -> (Employee)e)
//                .map(Employee::getFirstName)
//                .map(firstName -> firstName.split(""))
//                .flatMap(Arrays::stream)
//                .map(String::toLowerCase)
//                .distinct()
//                .forEach(System.out::println);

        Optional<Employee> optionEmp =  peopleText.lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee)e)
                .findFirst();

        System.out.println(optionEmp.map(Employee::getFirstName).orElse("Nobody"));

        Optional<String> output = Stream.of("tom", "marry", "sam")
                .reduce((a,b) -> a.concat("_").concat(b));
        System.out.println(output.orElse("")); // tom_marry_sam








        List<String> nums = List.of("one", "two", "three", "four");
        nums.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Collection<String> numbers = Set.of("one", "two", "three", "four");
        nums.stream()
                .map(String::hashCode)
                .forEach(System.out::println);

        record Car(String make, String model){}

        Stream.of(new Car("Ford", "Bronco"), new Car("Tesla", "X"), new Car("Mercedes", "LS"))
                .filter(c -> "Tesla".equals(c.make))
                .forEach(System.out::println);

        String myVar = "hello";
        Stream.of(myVar)
                .forEach(System.out::println);

        Stream.of(1,2,3); // Stream<Integer>

        IntStream.rangeClosed(1,40) // IntStream
                .forEach(System.out::println);

        // 1-2-3-4-5-
        IntStream.rangeClosed(1,5) // IntStream
                .mapToObj(String::valueOf)
                .map(s-> s.concat("-"))
                .forEach(System.out::print);

        System.out.println();

        String[] names = {"tom", "sam", "ted"};
        Arrays.stream(names)
                .forEach(System.out::println);

        try {
            Files.lines(Path.of("/Users/tamaratsymbaliuk/Documents/Repositories/Employees/src/main/java/employees/employees.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
