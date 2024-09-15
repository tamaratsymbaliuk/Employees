package employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee {
    private int avgSrockPrice = 0;

    private final String ceoRegex = "\\w+=(?<avgSrockPrice>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String personText) {
        super(personText);
            Matcher ceoMat = ceoPat.matcher(peopleMat.group("details"));
            if (ceoMat.find()) {
                this.avgSrockPrice = Integer.parseInt(ceoMat.group("avgSrockPrice"));
            }
        }
    public int getSalary() {
        return 5000 + avgSrockPrice;
    }
}
