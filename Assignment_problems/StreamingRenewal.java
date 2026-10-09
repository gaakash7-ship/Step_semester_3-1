package Assignment_problems;

import java.util.Scanner;
import java.time.LocalDate;

interface Plan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class Basic implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class Standard implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class Premium implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic();
            } else if (type.equals("STANDARD")) {
                plan = new Standard();
            } else {
                plan = new Premium();
            }

            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}