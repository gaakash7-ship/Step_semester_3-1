package Class_problems;

import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }
}

public class Garden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot p;

            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                p = new Circle(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                p = new Rectangle(owner, length, width);
            } else {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                p = new Triangle(owner, base, height);
            }

            double area = p.getArea();

            System.out.printf("%s (%s): %.2f%n",
                    owner, shape, area);

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}