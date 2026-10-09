package class_problems;

import java.util.Scanner;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate calculateDueDate(LocalDate currentDate);
}

class Book implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            // Remove quotation marks
            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }

            LocalDate dueDate = item.calculateDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}