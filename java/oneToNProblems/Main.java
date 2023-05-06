import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main ( String... args ) {

        List<Integer> list = Arrays.asList ( 1, 3, 2, 5, 5 );
        FindOneMissingDuplicate fomd = new FindOneMissingDuplicate ();

        System.out.println ( fomd.find ( list ) );
    }
}
