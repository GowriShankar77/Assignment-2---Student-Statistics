import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        // Read the file line by line
        while ((line = reader.readLine()) != null) {
            // Debugging: Print the line read from the file
            System.out.println("Read line: " + line);

            String[] data = line.split(","); // Adjust based on your file format
            if (data.length == 2) {
                String name = data[0].trim();
                double score = Double.parseDouble(data[1].trim());
                students.add(new Student(name, score));
            } else {
                System.out.println("Skipping invalid line: " + line);
            }
        }
        reader.close();  // Don't forget to close the reader
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students data available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void filterStudentsByThreshold(double threshold) {
        for (Student student : students) {
            if (student.getScore() >= threshold) {
                System.out.println(student);
            }
        }
    }

    public void displayTop5AndBottom5Students() {
        students.sort((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()));  // Sort in descending order
        System.out.println("Top 5 Students:");
        for (int i = 0; i < 5 && i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("Bottom 5 Students:");
        for (int i = students.size() - 1; i >= students.size() - 5 && i >= 0; i--) {
            System.out.println(students.get(i));
        }
    }
}


