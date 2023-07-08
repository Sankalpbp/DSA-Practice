public class NBitOneMoreThanZero {

    public static void permutation ( int n ) {
        permutation ( n, 0, 0, "" );
    }

    private static void permutation ( int n, int one, int zero, String output ) {
        if ( one + zero == n ) {
            System.out.println ( output );
            return;
        }

        if ( one > zero ) {
            permutation ( n, one, zero + 1, output + "0" );
        }

        permutation ( n, one + 1, zero, output + "1" );
    }
}
