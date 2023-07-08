public class Subsets {

    public static void printSubsets ( String input ) {
        printSubsets ( input, "" ); 
    }

    private static void printSubsets ( String input, String output ) {
        if ( input.length () == 0 ) {
            if ( output.length () == 0 ) {
                output = "\"\"";
            }
            System.out.println ( output );
            return;
        }

        printSubsets ( input.substring ( 1 ), output );
        printSubsets ( input.substring ( 1 ), output + input.charAt ( 0 ) );
    }
}
