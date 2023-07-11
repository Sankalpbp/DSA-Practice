import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main ( String... args ) {
        List<Integer> weights = new ArrayList<> ( Arrays.asList ( 4, 5, 1 ) );
        List<Integer> values = new ArrayList<> ( Arrays.asList ( 1, 2, 3 ) );

        List<Integer> weights1 = new ArrayList<> ( Arrays.asList ( 4, 5, 6 ) );
        List<Integer> values1 = new ArrayList<> ( Arrays.asList ( 1, 2, 3 ) );

        System.out.println ( ZeroOneKnapsack.getProfitRecursive ( weights, values, 4 ) );
        System.out.println ( ZeroOneKnapsack.getProfitRecursive ( weights1, values1, 3 ) );

        System.out.println ( ZeroOneKnapsack.getProfitMemo ( weights, values, 4 ) );
        System.out.println ( ZeroOneKnapsack.getProfitMemo ( weights1, values1, 3 ) );

        System.out.println ( ZeroOneKnapsack.getProfitDP ( weights, values, 4 ) );
        System.out.println ( ZeroOneKnapsack.getProfitDP ( weights1, values1, 3 ) );

        List<Integer> weights2 = new ArrayList<> ( Arrays.asList ( 1, 50 ) );
        List<Integer> values2 = new ArrayList<> ( Arrays.asList ( 1, 30 ) );

        List<Integer> weights3 = new ArrayList<> ( Arrays.asList ( 1, 3, 4, 5 ) );
        List<Integer> values3 = new ArrayList<> ( Arrays.asList ( 10, 40, 50, 70 ) );

        System.out.println ( UnboundedKnapsack.getProfitRecursive ( weights2, values2, 100 ) );
        System.out.println ( UnboundedKnapsack.getProfitRecursive ( weights3, values3, 8 ) );

        System.out.println ( UnboundedKnapsack.getProfitMemo ( weights2, values2, 100 ) );
        System.out.println ( UnboundedKnapsack.getProfitMemo ( weights3, values3, 8 ) );

        System.out.println ( UnboundedKnapsack.getProfitDP ( weights2, values2, 100 ) );
        System.out.println ( UnboundedKnapsack.getProfitDP ( weights3, values3, 8 ) );

        System.out.println ( LongestCommonSubsequence.lcsRecursive ( "AGGTAB", "GXTXAYB" ) );
        System.out.println ( LongestCommonSubsequence.lcsMemo ( "AGGTAB", "GXTXAYB" ) );
        System.out.println ( LongestCommonSubsequence.lcsDP ( "AGGTAB", "GXTXAYB" ) );
        
        List<Integer> dimensions = new ArrayList<> ( Arrays.asList ( 40, 20, 30, 10, 30 ) );
        System.out.println ( MatrixChainMultiplication.solveRecursive ( dimensions ) );
        System.out.println ( MatrixChainMultiplication.solveMemo ( dimensions ) );

        System.out.println ( PalindromicPartitioning.partitions ( "geek" ) );
        System.out.println ( PalindromicPartitioning.partitionsMemo ( "geek" ) );
    }
}
