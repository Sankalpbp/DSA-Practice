import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main ( String... args ) {

        PrintOneToN.print ( 10 );
        System.out.println ( Factorial.factorial ( 5 ) );

        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 1, 2, 3, 5 ), 4 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 3, 4, 9, 10 ), 8 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 3, 4, 5 ), 2 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 1, 2, 3 ), 4 ) );

        List<Integer> array = new ArrayList<> ( Arrays.asList ( 3, 5, 6 ) );
        ShiftAndPutInSortedArray.shiftAndPut ( array, 2 );
        System.out.println ( array );

        List<Integer> input = new ArrayList<> ( Arrays.asList ( 3, 2, 1 ) );
        List<Integer> input1 = new ArrayList<> ( Arrays.asList ( 1, 2, 3 ) );
        List<Integer> input2 = new ArrayList<> ( Arrays.asList ( 1, 3, 2 ) );
        SortArray.sort ( input );
        SortArray.sort ( input1 );
        SortArray.sort ( input2 );
        System.out.println ( input );
        System.out.println ( input1 );
        System.out.println ( input2 );

        System.out.println ( input1 );
        System.out.println ( "Reversing..." );
        ReverseArray.reverse ( input1 );
        System.out.println ( input1 );

        Stack<Integer> stack = new Stack<> ();
        stack.push ( 3 );
        stack.push ( 9 );
        stack.push ( 2 );

        PrintStackTopToBottom.print ( stack );
        PrintStackBottomToTop.print ( stack );

        
        System.out.println ( "Before: " + stack );
        ReverseStack.reverse ( stack );
        System.out.println ( "After: " + stack );

        System.out.println ( "Before: " + stack );
        SortStack.sort ( stack );
        System.out.println ( "After: " + stack );

        Stack<Integer> anotherStack = new Stack<> ();
        anotherStack.push ( 1 );
        anotherStack.push ( 2 );
        anotherStack.push ( 3 );
        System.out.println ( "Before: " + anotherStack );
        SortStack.sort ( anotherStack );
        System.out.println ( "After: " + anotherStack );

        System.out.println ( input2 );
        DeleteElementFromArray.delete ( input2, 3 );
        System.out.println ( input2 );

        List<Integer> input5 = new ArrayList<> ( Arrays.asList ( 1 ) );
        System.out.println ( input5 );
        DeleteElementFromArray.delete ( input5, 1 );
        System.out.println ( input5 );
        DeleteElementFromArray.delete ( input5, 1 );
        System.out.println ( input5 );

        System.out.println ( anotherStack );
        DeleteFromStack.delete ( anotherStack, 2 );
        System.out.println ( anotherStack );

        Stack<Integer> input10 = new Stack<> ();
        input10.push ( 1 );
        input10.push ( 2 );
        input10.push ( 3 );
        input10.push ( 4 );
        input10.push ( 5 );
        System.out.println ( input10 );
        DeleteMiddleElementFromStack.delete ( input10 );
        System.out.println ( input10 );

        System.out.println ( KthSymbol.kth ( 4, 6 ) );
        System.out.println ( KthSymbol.kth ( 2, 2 ) );
        System.out.println ( KthSymbol.kth ( 3, 3 ) );
        System.out.println ( KthSymbol.kth ( 5, 4 ) );

        TowerOfHanoi.toh ( 10, 's', 'd', 'h' );
    }
}
