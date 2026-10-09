package Assignemnt_problems;

import java.util.Scanner;

abstract class Cab {
    static final double MIN_FARE = 100;

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        return Math.max(km * getRate(), MIN_FARE);
    }
}

interface NightService {
    double nightFare(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

public class cab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab c;

            if (type.equals("MINI")) {
                c = new Mini(km);
            } else if (type.equals("SEDAN")) {
                c = new Sedan(km);
            } else {
                c = new SUV(km);
            }

            if (time.equals("NIGHT")) {
                if (c instanceof NightService) {
                    NightService ns = (NightService) c;
                    double fare = ns.nightFare(c.getFare());

                    System.out.printf("%s: %.2f%n", type, fare);
                    total += fare;
                } else {
                    System.out.println(type + ": night service not available");
                }
            } else {
                double fare = c.getFare();

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
