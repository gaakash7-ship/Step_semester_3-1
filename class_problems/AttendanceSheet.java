package class_problems;

public class AttendanceSheet {
    private String[] students;
    private int presentCount;

    AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {
        // Check for duplicate
        if (isPresent(name)) {
            return;
        }

        // Add student if space is available
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}
