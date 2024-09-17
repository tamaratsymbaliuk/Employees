package employees;

import java.time.LocalDate;

public record WeirdoR(String lastName, String firstName, LocalDate dob) {
    // look at the Weirdo class, the record provides constructor, getter,(no setters) etc automatically
    // record and fields within it are final and can't be extended
}
