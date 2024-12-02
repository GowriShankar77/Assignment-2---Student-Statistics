import java.util.Scanner;
import java.io.IOException;


public class Menu {
    private StudentManager manager = new StudentManager();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Load Data from File");
            System.out.println("2. Display All Students");
            System.out.println("3. Filter Students by Threshold");
            System.out.println("4. Display Top 5 and Bottom 5 Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> loadFile();
                case 2 -> displayAllStudents();
                case 3 -> filterStudents();
                case 4 -> displayTopAndBottomStudents();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void loadFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try {
            manager.readFile(fileName);
            System.out.println("File loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private void displayAllStudents() {
        for (Student student : manager.getStudents()) {
            System.out.println(student);
        }
    }

    private void filterStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();
        for (Student student : manager.filterStudents(threshold)) {
            System.out.println(student);
        }
    }

    private void displayTopAndBottomStudents() {
        System.out.println("Top 5 Students:");
        for (Student student : manager.getTopStudents()) {
            System.out.println(student);
        }
        System.out.println("Bottom 5 Students:");
        for (Student student : manager.getBottomStudents()) {
            System.out.println(student);
        }
    }
}

