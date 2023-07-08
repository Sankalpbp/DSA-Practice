import java.util.List;

public class Main2 {

    public static void main ( String... args ) {

        Subsets.printSubsets ( "abc" );
        List<String> output = StoreSubsets.store ( "abc" );
        System.out.println ( output );

        PermutationWithSpaces.permutation ( "abc" );

        PermutationWithCaseChange.permutation ( "ab" );

        LetterCasePermutation.permutation ( "a1B2" );

        GenerateBalancedParentheses.permutation ( 4 );
        GenerateBalancedParentheses.permutation ( 3 );

        System.out.println ( "\n\nn = 4" );
        NBitOneMoreThanZero.permutation ( 4 );
        System.out.println ( "\n\nn = 3" );
        NBitOneMoreThanZero.permutation ( 3 );
        System.out.println ( "\n\nn = 2" );
        NBitOneMoreThanZero.permutation ( 2 );
        System.out.println ( "\n\nn = 5" );
        NBitOneMoreThanZero.permutation ( 5 );

        System.out.println ( "\n\n\n" );
        System.out.println ( JosephusProblem.josephus ( 5, 2 ) );
        
    }
}
