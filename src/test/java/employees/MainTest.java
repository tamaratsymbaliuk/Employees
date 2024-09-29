package employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testNameToSalary() {
        Main main = new Main();
        main.main(new String[0]);
        int salary = main.getSalary("Wilma");
        assertEquals(2500, salary);
    }

    @Test
    public void testInvalidNameToSalary() {
        Main main = new Main();
        main.main(new String[0]);
        int salary = main.getSalary("Uma");
        assertEquals(-1, salary);
    }




}