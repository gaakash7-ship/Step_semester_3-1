package Assignment_problems;

import java.util.Scanner;

abstract class Ticket {
    static final double FEE = 20.0;

    abstract double getPrice();

    double getAmount(int count) {
        return (getPrice() + FEE) * count;
    }
}

class Regular extends Ticket {
    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400;
    }
}

public class cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket t;

            if (seat.equals("REGULAR")) {
                t = new Regular();
            } else if (seat.equals("PREMIUM")) {
                t = new Premium();
            } else {
                t = new Recliner();
            }

            double amount = t.getAmount(count);

            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}