package employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements Flyer {
    private int avgSrockPrice = 0;
    private Pilot pilot = new Pilot(1000, true);

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

    public void fly() {
        pilot.fly();
    }

    public int getHoursFlown() {
        return pilot.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        pilot.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }
}
