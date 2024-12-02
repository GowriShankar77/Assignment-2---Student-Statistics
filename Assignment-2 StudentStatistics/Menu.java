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

        // Debugging: Print current directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        System.out.println("Attempting to load file from: " + fileName);

        try {
            // For testing, you can hardcode the file path as absolute path for now
            String absoluteFilePath = "C:\\Users\\gowri\\Desktop\\Units\\Fundamentals of programming\\Assignment 2\\Assignment-2 StudentStatistics\\students.txt";
            manager.readFile(absoluteFilePath);  // Use absolute path for testing
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
        System.out.print("Enter the threshold: ");
        double threshold = scanner.nextDouble();
        manager.filterStudentsByThreshold(threshold);
    }

    private void displayTopAndBottom5Students() {
        manager.displayTop5AndBottom5Students();
    }
}

    



