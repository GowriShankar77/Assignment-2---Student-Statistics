import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private StudentManager manager;

    public Menu() {
        manager = new StudentManager();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--- Student Management System ---");
            System.out.println("1. Load Data from File");
            System.out.println("2. Display All Students");
            System.out.println("3. Filter Students by Threshold");
            System.out.println("4. Display Top 5 and Bottom 5 Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    loadFile(scanner);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    filterStudentsByThreshold(scanner);
                    break;
                case 4:
                    displayTopAndBottom5Students();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
    }

    private void loadFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        try {
            if (!file.exists()) {
                System.out.println("Error: The file '" + fileName + "' does not exist.");
                return;
            }

            if (file.length() == 0) {
                System.out.println("Error: The file '" + fileName + "' is empty.");
                return;
            }

            manager.readFile(fileName);
            System.out.println("File loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + fileName);
            System.out.println(e.getMessage());
        }
    }

    private void displayAllStudents() {
        manager.displayAllStudents();
    }

    private void filterStudentsByThreshold(Scanner scanner) {
        double threshold;

        while (true) {
            System.out.print("Enter the threshold (non-negative): ");
            threshold = scanner.nextDouble();

            if (threshold >= 0) {
                break;
            } else {
                System.out.println("Error: Threshold cannot be negative. Please try again.");
            }
        }

        manager.filterStudentsByThreshold(threshold);
    }

    private void displayTopAndBottom5Students() {
        manager.displayTop5AndBottom5Students();
    }
}


    



