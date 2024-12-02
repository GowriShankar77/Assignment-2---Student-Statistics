import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("#") || line.isBlank()) continue; // Skip comments
            String[] parts = line.split(",");
            String id = parts[0].trim();
            String name = parts[1].trim();
            int[] marks = Arrays.stream(parts[2].split(" ")).mapToInt(Integer::parseInt).toArray();
            students.add(new Student(id, name, marks));
        }
        br.close();
    }

    public List<Student> filterStudents(int threshold) {
        List<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getTotalMarks() < threshold) {
                filtered.add(student);
            }
        }
        return filtered;
    }

    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingInt(Student::getTotalMarks).reversed());
    }

    public List<Student> getTopStudents() {
        sortStudentsByMarks();
        return students.subList(0, Math.min(5, students.size()));
    }

    public List<Student> getBottomStudents() {
        sortStudentsByMarks();
        return students.subList(Math.max(0, students.size() - 5), students.size());
    }

    public List<Student> getStudents() {
        return students;
    }
}

