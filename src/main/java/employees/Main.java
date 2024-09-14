package employees;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String peopleText = """
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone2, Fred2, 1/01/1900, Programmer, {locpd=1300,yoe=14,iq=100}
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

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
        Pattern peoplePat = Pattern.compile(peopleRegex);
        Matcher peopleMat = peoplePat.matcher(peopleText);

        String progRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
        Pattern coderPat = Pattern.compile(progRegex);

        String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
        Pattern mgrPat = Pattern.compile(mgrRegex);

        String analystRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
        Pattern analystPat = Pattern.compile(analystRegex);

        String ceoRegex = "\\w+=(?<avgSrockPrice>\\w+),\\w+=(?<dr>\\w+)";
        Pattern ceoPat = Pattern.compile(ceoRegex);


        int totalSalaries = 0;
        while (peopleMat.find()) {
           totalSalaries+= switch (peopleMat.group("role")) {
                case "Programmer" -> {

                    Programmer programmer = new Programmer(peopleMat.group());
                    System.out.println(programmer.toString());
                    yield programmer.getSalary();

                }
                case "Manager" -> {
                    Manager manager = new Manager(peopleMat.group());
                    System.out.println(manager.toString());
                    yield manager.getSalary();
                }
                case "Analyst" -> {
                    Analyst analyst = new Analyst(peopleMat.group());
                    System.out.println(analyst.toString());
                    yield analyst.getSalary();
                }
                case "CEO" -> {
                    CEO ceo = new CEO(peopleMat.group());
                    System.out.println(ceo.toString());
                    yield ceo.getSalary();
                }
               default -> {
                    yield 0;
               }
            };
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
    }
}