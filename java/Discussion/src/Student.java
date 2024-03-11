public class Student implements Comparable<Student> {
    private String name;
    private int rollNumber;
    private int marks;

    public Student () {
    }

    public Student ( String name, int rollNumber, int marks ) {
        this.marks = marks;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare ( this.getRollNumber (), student.getRollNumber() );
    }

    public int getMarks () {
        return marks;
    }

    public int getRollNumber () {
        return rollNumber;
    }

    public String getName () {
        return name;
    }

    public String toString () {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks;
    }

}
