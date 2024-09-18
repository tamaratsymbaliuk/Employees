package employees;

import java.time.LocalDate;

public record WeirdoR(String lastName, String firstName, LocalDate dob)  {
    // look at the Weirdo class, the record provides constructor, getter,(no setters) etc automatically
    // record and fields within it are final and record can't be extended to other classes hence not abstract
    // custom constructor
    public WeirdoR(String lastName, String firstName) {
        this(lastName, firstName, LocalDate.of(1,1,1));
    }

}
