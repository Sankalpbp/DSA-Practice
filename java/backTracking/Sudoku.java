import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {

    private static final int NUMBER_OF_CELLS_IN_AN_EDGE = 9;
    private static final int NUMBER_OF_CELLS_IN_A_SUBBOX = 3;

    private static boolean solve ( int [][] sudoku ) {

        Cell emptyCell = getNextEmptyCell ( sudoku );
        if ( emptyCell == null ) {
            return true;
        }

        for ( int x = 1; x <= 9; ++x ) {
            if ( isSafeToPut ( sudoku, emptyCell, x ) ) {
                sudoku [ emptyCell.row ][ emptyCell.column ] = x;
                if ( solve ( sudoku ) ) {
                    return true;
                }
                sudoku [ emptyCell.row ][ emptyCell.column ] = 0;
            }
        }

        return false;
    }

    private static boolean isSafeToPut ( int [][] sudoku, Cell cell, int x ) {
        return !( doesRowContainX ( sudoku, cell.row, x ) 
                || doesColumnContainX ( sudoku, cell.column, x ) 
                || doesSubSquareContainX ( sudoku, cell.row, cell.column, x ) );
    }

    private static boolean doesSubSquareContainX ( int [][] sudoku, int row, int column, int x ) {
        int leftMostCellRow = ( row - ( row % NUMBER_OF_CELLS_IN_A_SUBBOX ) );
        int leftMostCellColumn = ( column - ( column % NUMBER_OF_CELLS_IN_A_SUBBOX ) );

        for ( int i = leftMostCellRow; i < leftMostCellRow + 3; ++i ) {
            for ( int j = leftMostCellColumn; j < leftMostCellColumn + 3; ++j ) {
                if ( sudoku [ i ][ j ] == x ) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doesColumnContainX ( int [][] sudoku, int column, int x ) {
        for ( int row = 0; row < NUMBER_OF_CELLS_IN_AN_EDGE; ++row ) {
            if ( sudoku [ row ][ column ] == x ) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesRowContainX ( int [][] sudoku, int row, int x ) {
        for ( int column = 0; column < NUMBER_OF_CELLS_IN_AN_EDGE; ++column ) {
            if ( sudoku [ row ][ column ] == x ) {
                return true;
            }
        }
        return false;
    }

    private static Cell getNextEmptyCell ( int [][] sudoku ) {
        for ( int i = 0; i < NUMBER_OF_CELLS_IN_AN_EDGE; ++i ) {
            for ( int j = 0; j < NUMBER_OF_CELLS_IN_AN_EDGE; ++j ) {
                if ( sudoku [ i ][ j ] == 0 ) {
                    return new Cell ( i, j );
                }
            }
        }

        return null;
    }

    private static void printMatrix ( int [][] matrix ) {
        for ( int i = 0; i < matrix.length; ++i ) {
            for ( int j = 0; j < matrix [ 0 ].length; ++j ) {
                System.out.print ( matrix [ i ][ j ] + " " );
            }
            System.out.println ( );
        }
    }

    public static void print ( int [][] sudoku ) {
        if ( solve ( sudoku ) && checkSolution ( sudoku ) ) {
            System.out.println ( "Sudoku Solver is working correctly! Here is your solution: " );
            printMatrix ( sudoku );
            return;
        }

        System.out.println ( "Sudoku Solver is working incorrectly" );
    }

    private static boolean checkSolution ( int [][] sudoku ) {
        int [][] solution = new int [ NUMBER_OF_CELLS_IN_AN_EDGE ][ NUMBER_OF_CELLS_IN_AN_EDGE ];

        try ( BufferedReader br = new BufferedReader ( new FileReader ( "sudokuSolution.txt" ) ) ) {
            String line;
            int row = 0;

            while ( ( line = br.readLine () ) != null && row < NUMBER_OF_CELLS_IN_AN_EDGE ) {
                String [ ] values = line.split ( " " );
                for ( int column = 0; column < values.length && column < NUMBER_OF_CELLS_IN_AN_EDGE; ++column ) {
                    solution [ row ][ column ] = Integer.parseInt ( values [ column ] );
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace ( );
        }

        for ( int i = 0; i < NUMBER_OF_CELLS_IN_AN_EDGE; ++i ) {
            for ( int j = 0; j < NUMBER_OF_CELLS_IN_AN_EDGE; ++j ) {
                if ( solution [ i ][ j ] == sudoku [ i ][ j ] ) {
                    return false;
                }
            }
        }



        return true;
    }

    private static class Cell {
        public int row;
        public int column;

        public Cell ( int row, int column ) {
            this.row = row;
            this.column = column;
        }
    }

}
