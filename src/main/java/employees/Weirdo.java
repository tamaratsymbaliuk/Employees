package employees;

import java.time.LocalDate;
import java.util.Objects;

public class Weirdo {
    private String lastName;
    private String firstName;
    private LocalDate dob;

    public Weirdo(String lastName, String firstName, LocalDate dob) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weirdo weirdo = (Weirdo) o;
        return Objects.equals(lastName, weirdo.lastName) && Objects.equals(firstName, weirdo.firstName) && Objects.equals(dob, weirdo.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, dob);
    }
}
