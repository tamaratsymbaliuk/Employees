package employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        String peopleText = """
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone2, Fred2, 1/01/1900, Programmerzzzz, {locpd=1300,yoe=14,iq=100}
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

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(peopleText);
        //Flyer pilot = new CEO("");
       // pilot.fly();

        Programmer coder = new Programmer("test");
        coder.cook("Hamburger"); // cook is a default method of Chef interface




        int totalSalaries = 0;
         IEmployee employee = null; // IEmployee employee = null;
        // made IEmployee just to show that nothing breaks because IEmpl interface implements getSalary method from Employee class
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
                System.out.println(employee.toString());
                totalSalaries += employee.getSalary();
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));

        WeirdoR larry = new WeirdoR("Tom", "Larry", LocalDate.of(1993, 11, 24));
        larry.firstName();

    }
}
// we use interface when we don't have a lot of data in common but want to combine different classes to use the same methods and implement them
// here I decided to use super Employee class, because all the subclasses share the same data (f.e. first name, last name, constructor implementation)
// I also made the super class abstract, so it can't be instantiated and a one abstract method getSalary, so all subclasses are forced to implement the abstract getSalary method