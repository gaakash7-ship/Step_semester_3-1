package class_problems;

import java.util.Scanner;

interface Delivery {
    double calculateFee(double weight, double distance);
}

class Standard implements Delivery {
    public double calculateFee(double weight, double distance) {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class Express implements Delivery {
    public double calculateFee(double weight, double distance) {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class International implements Delivery {
    private double customsFee;

    International(double customsFee) {
        this.customsFee = customsFee;
    }

    public double calculateFee(double weight, double distance) {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new Standard();
            } else if (type.equals("EXPRESS")) {
                delivery = new Express();
            } else {
                double customsFee = sc.nextDouble();
                delivery = new International(customsFee);
            }

            double fee = delivery.calculateFee(weight, distance);

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}