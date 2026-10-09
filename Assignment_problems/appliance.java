package Assignemnt_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return getPower() * hours / 1000;
    }

    double getCost() {
        return getUnits() * COST_PER_UNIT;
    }
}

interface SaverMode {
    double getSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double getPower() {
        return 1500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double getPower() {
        return 500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

public class appliance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance a;

            if (type.equals("FRIDGE")) {
                a = new Fridge(hours);
            } else if (type.equals("AC")) {
                a = new AC(hours);
            } else if (type.equals("TV")) {
                a = new TV(hours);
            } else {
                a = new Washer(hours);
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units;

                if (saver) {
                    SaverMode s = (SaverMode) a;
                    units = s.getSaverUnits();
                } else {
                    units = a.getUnits();
                }

                double cost = units * Appliance.COST_PER_UNIT;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
                );

                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}