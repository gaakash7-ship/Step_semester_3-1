package Assignment_problems;


import java.util.Scanner;

public class FestivalBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            double bonus = 0;

            switch (type) {
                case "FULLTIME":
                    bonus = salary * 0.10;
                    break;

                case "PARTTIME":
                    bonus = salary * 0.05;
                    break;

                case "INTERN":
                    bonus = 2000;
                    break;
            }

            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}