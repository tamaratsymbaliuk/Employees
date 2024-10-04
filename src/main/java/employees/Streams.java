package employees;

public class Streams {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=4000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=5000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=6000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=7000,yoe=10,iq=140}
                Flinstone, Fred, 1/01/1900, Programmer, {locpd=8000,yoe=10,iq=140}
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

        peopleText.lines()
                .map(Employee::createEmployee)
                .forEach(System.out::println);
    }
}
