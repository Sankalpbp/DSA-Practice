public class PermutationWithCaseChange {

    public static void permutation ( String input ) {
        permutation ( input, "" );
    }

    private static void permutation ( String input, String output ) {
        if ( input.length () == 0 ) {
            System.out.println ( output );
            return;
        }

        permutation ( input.substring ( 1 ), output + input.charAt ( 0 ) );
        permutation ( input.substring ( 1 ), output + Character.toUpperCase ( input.charAt ( 0 ) ) );
    }
}
