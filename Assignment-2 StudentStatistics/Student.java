public class Student {
    private String id;
    private String name;
    private int[] marks;
    private int totalMarks;

    public Student(String id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        calculateTotalMarks();
    }

    public void calculateTotalMarks() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int[] getMarks() { return marks; }
    public int getTotalMarks() { return totalMarks; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Marks: %s, Total: %d",
                id, name, java.util.Arrays.toString(marks), totalMarks);
    }
}

