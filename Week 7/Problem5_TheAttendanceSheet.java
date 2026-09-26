class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        presentStudents = new String[capacity];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid student name");
            return;
        }
        if (isPresent(name)) {
            return;
        }
        if (presentCount >= presentStudents.length) {
            System.out.println("Cannot mark present: attendance sheet is full");
            return;
        }
        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem5_TheAttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}