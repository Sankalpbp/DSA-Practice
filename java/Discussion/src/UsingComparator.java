import java.util.Arrays;
import java.util.Comparator;

public class UsingComparator {

    public static void sortMarksWise (Student[] students) {

        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return Integer.compare ( student.getMarks(), t1.getMarks () );
            }
        };

        Arrays.sort ( students, ( s1, s2 ) -> Integer.compare ( s1.getMarks(), s2.getMarks() ) );
    }

    /*
    private static class StudentComparator implements Comparator<Student> {
        public int compare ( Student a, Student b ) {
            return Integer.compare ( a.getMarks(), b.getMarks () );
        }
    }
     */

}

/*
public interface Comparator<T> {

    public int compare ( T a, T b ) {
        // logic to compare a and b
    }

}

 */