package employees;

import com.sun.source.tree.Tree;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    private static Set<IEmployee> employees;

    public static void main(String[] args) {

        String peopleText = """
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
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


        int totalSalaries = 0;
         IEmployee employee = null; // IEmployee employee = null;
        employees = new TreeSet<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
        }



//        List<String> undesirables = new ArrayList<>(List.of("Wilma5", "Barney4","Fred2"));
//        undesirables.sort(Comparator.naturalOrder());
//     //   System.out.println(undesirables + " undeserables");
//
//        List<String> newStrings = new ArrayList<>();
//        newStrings.addAll(undesirables);
//       // System.out.println(newStrings.size());
//
//        removeUndesirables(employees, undesirables);
//
//
//        Collections.sort(employees, Comparator.naturalOrder());
//        employees.sort((o1, o2) -> {
//            if (o1 instanceof Employee emp1 && o2 instanceof Employee emp2) { // casting to Employee emp
//                int lnameResult = emp1.lastName.compareTo(emp2.lastName);
//                return lnameResult != 0 ? lnameResult : emp1.firstName.compareTo(emp2.firstName);
//            }
//            return 0;
//        });

        for (IEmployee worker : employees) {
            System.out.println(worker.toString());
            totalSalaries += worker.getSalary();
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
        System.out.println(employees.size());
    }

    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
        for (Iterator<IEmployee> it = employees.iterator(); it.hasNext();) {
            IEmployee worker = it.next();
            if (worker instanceof Employee tmpWorker) {
               // Employee tmpWorker = (Employee) worker;
                if (removalNames.contains(tmpWorker.firstName)) {
                    it.remove();
                }
            }
        }
    }

    public int getSalary(String firstName) {
        for (IEmployee employee : employees) {
            Employee emp = (Employee) employee;
            if (firstName.equals(emp.firstName)) {
                return emp.getSalary();
            }
        }
        return 0;
    }
}
// we use interface when we don't have a lot of data in common but want to combine different classes to use the same methods and implement them
// here I decided to use super Employee class, because all the subclasses share the same data (f.e. first name, last name, constructor implementation)
// I also made the super class abstract, so it can't be instantiated and a one abstract method getSalary, so all subclasses are forced to implement the abstract getSalary method