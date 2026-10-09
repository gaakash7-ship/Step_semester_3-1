package Assignemnt_problems;

import java.util.Scanner;

abstract class Student {
    String name;
    static final double TUITION = 40000;
    static final double BUS_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getHostelFee() {
        return 0;
    }

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        double total = getTuition() + getHostelFee();

        if (usesBus()) {
            total += BUS_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return TUITION;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return TUITION;
    }

    double getHostelFee() {
        return 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return TUITION / 2;
    }

    boolean usesBus() {
        return true;
    }
}

public class college {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            if (type.equals("DAY_SCHOLAR")) {
                s = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                s = new Hosteller(name);
            } else {
                s = new Scholar(name);
            }

            double fee = s.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
