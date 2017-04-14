import java.util.*;
import java.io.*;


/**
 * Chapter 49C - Two-Dimensional Arrays Exercises 1-8
 * 
 * @author Bryan Wu
 * @version 1/29/15
 * @author Period - 7
 * @author Assignment - Ch49C_2DArrays
 * @author Sources - none
 */
public class Ch49C_2DArrays
{
    Scanner scan;


    public Ch49C_2DArrays()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Computes the sum of all the elements of the array.
     *
     * @param data
     *            data
     * @return sumOfAllArrayElements
     */
    public int sumOfAllArrayElements( int[][] data )
    {
        int sum = 0;// declare the sum

        // compute the sum
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                sum = sum + data[row][col];
            }
        }

        // write out the sum
        System.out.println( "Sum: " + sum );

        return sum;
    }


    /**
     * Computes the sum of the elements in each row.
     *
     * @param data
     *            data
     * @return sumOfEachRow
     */
    public int[] sumOfEachRow( int[][] data )
    {
        // declare the row sum array
        int[] rowSums = new int[data.length];

        // compute the sums for each row
        for ( int row = 0; row < data.length; row++ )
        {
            int sum = 0;// initialize the sum

            // compute the sum for this row
            for ( int col = 0; col < data[row].length; col++ )
            {
                sum = sum + data[row][col];
                rowSums[row] = sum;
            }

            // write the sum for this row
            System.out.println( "Sum of Row " + ( row + 1 ) + ": " + sum );
        }

        return rowSums;
    }


    /**
     * Computes and prints the sum of each column of the array.
     *
     * @param data
     *            data
     * @return sumOfEachColumn
     */
    public int[] sumOfEachColumn( int[][] data )
    {
        // find the longest row
        int longestRow = 0;

        for ( int i = 0; i < data.length; i++ )
        {
            if ( data[i].length > longestRow )
            {
                longestRow = data[i].length;
            }
        }

        int[] colSums = new int[longestRow]; // declare the row sum array
        int[] rowLengths = new int[data.length]; // array to store lengths of
                                                 // rows

        for ( int row = 0; row < data.length; row++ ) // find the length of each
                                                      // row
        {
            rowLengths[row] = data[row].length;
        }

        for ( int col = 0; col < longestRow; col++ ) // start finding sums
        {
            int sum = 0;
            for ( int row = 0; row < data.length; row++ )
            {
                if ( col < rowLengths[row] )
                {
                    sum = sum + data[row][col];
                    colSums[col] = sum;
                }
            }
            System.out.println( "Sum of Row " + ( col + 1 ) + ": " + sum );
        }

        return colSums;
    }


    /**
     * Computes the maximum and minimum of the elements in the array
     *
     * @param data
     *            data
     * @return maxAndMinElements
     */
    public int[] maxAndMinElements( int[][] data )
    {
        // declare the max and the min
        int max = data[0][0];
        int min = data[0][0];

        // compute the sum
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                if ( max < data[row][col] )
                {
                    max = data[row][col];
                }
                if ( min > data[row][col] )
                {
                    min = data[row][col];
                }
            }
        }

        // write out the results
        System.out.println( "Maximum: " + max );
        System.out.println( "Minimum: " + min );

        int[] result = { max, min };
        return result;
    }


    /**
     * Computes and prints the largest element in each row.
     *
     * @param data
     *            data
     * @return largestElements
     */
    public int[] largestElements( int[][] data )
    {
        // declare the largest in row array
        int[] largestInRow = new int[data.length];

        for ( int row = 0; row < data.length; row++ )
        {
            int max = data[0][0];

            for ( int col = 0; col < data[row].length; col++ )
            {
                if ( max < data[row][col] )
                {
                    max = data[row][col];
                    largestInRow[row] = max;
                }
            }
            System.out.println( "Maximum of Row " + ( row + 1 ) + ": " + max );
        }

        return largestInRow;
    }


    /**
     * Program that reverses the order of the elements in each row of the
     * matrix, then prints out the resulting matrix.
     * 
     * @param data
     *            data
     */
    public void reversalOfElementsInEachRow( int[][] data )
    {
        int temp;

        for ( int row = 0; row < data.length; row++ )
        {
            int dataLength = data[row].length - 1;
            for ( int col = 0; col < ( data[row].length ) / 2; col++ )
            {
                temp = data[row][col];
                data[row][col] = data[row][dataLength];
                data[row][dataLength] = temp;
                dataLength--;

            }

        }
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                System.out.print( data[row][col] + " " );
            }
            System.out.println( "" );
        }
    }


    /**
     * Compute the smoothed array by doing this: Each value smooth[r][c] is the
     * average of nine values
     * 
     * @param image
     *            image
     * @return imageSmootherEasy
     */
    public int[][] imageSmootherEasy( int[][] image )
    {
        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];

        // image[r-1][c-1], image[r-1][c ], image[r-1][c+1],
        // image[r ][c-1], image[r ][c ], image[r ][c+1],
        // image[r+1][c-1], image[r+1][c ], image[r+1][c+1].

        // Compute the smoothed value for
        // non-edge locations in the image.

        int sum = 0;
        // int imageLength = image[0].length - 1;
        // int imageWidth = image.length - 1;

        for ( int r = 1; r < image.length - 1; r++ )
        {
            int c;

            for ( c = 1; c < image[r].length - 1; c++ )
            {
                sum = sum + image[r - 1][c - 1] + image[r - 1][c]
                    + image[r - 1][c + 1] + image[r][c - 1] + image[r][c]
                    + image[r][c + 1] + image[r + 1][c - 1] + image[r + 1][c]
                    + image[r + 1][c + 1];
                smooth[r][c] = sum / 9;
                sum = 0;
            }
        }

        // write out the input
        System.out.println( "Input: " );
        for ( int r = 0; r < image.length - 1; r++ )
        {
            for ( int col = 0; col < image[r].length; col++ )
            {
                System.out.print( image[r][col] + " " );
            }
            System.out.println( "" );
        }
        // write out the result
        System.out.println( "" );
        System.out.println( "Output: " );
        for ( int r = 0; r < smooth.length - 1; r++ )
        {
            for ( int col = 0; col < smooth[r].length; col++ )
            {
                System.out.print( smooth[r][col] + " " );
            }
            System.out.println( "" );
        }

        return smooth;
    }


    /**
     * For each location in the image, average together only those of the nine
     * values that exist. This calls for some fairly tricky if statements, or a
     * tricky set of for statements inside the outer two.
     * 
     * @param image
     *            image
     * @return imageSmootherHard
     */
    public int[][] imageSmootherHard( int[][] image )
    {
        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];
        int[][] iceCreamTruck = new int[image.length + 2][image[0].length + 2];

        for ( int row = 0; row < image.length; row++ )
        {
            for ( int col = 0; col < image[row].length; col++ )
            {
                iceCreamTruck[row + 1][col + 1] = image[row][col];
            }
        }

        iceCreamTruck = imageSmootherEasy( iceCreamTruck );

        for ( int row = 0; row < smooth.length; row++ )
        {
            for ( int col = 0; col < smooth[row].length; col++ )
            {
                smooth[row][col] = iceCreamTruck[row + 1][col + 1];
            }
        }
        return smooth;
    }


    /**
     * Testing method: instantiates a Lesson49C Exercises object and then
     * invokes each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch49C_2DArrays exercise = new Ch49C_2DArrays();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of All Array Elements" );
            System.out.println( "   (2) Sum of Each Row" );
            System.out.println( "   (3) Sum of Each Column" );
            System.out.println( "   (4) Maximum and Minimum Elements" );
            System.out.println( "   (5) Largest Elements" );
            System.out.println( "   (6) Reversal of Elements in Each Row" );
            System.out.println( "   (7) Image Smoother (Easy)" );
            System.out.println( "   (8) Image Smoother (Hard)" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        int[][] dataEx1 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int sum = exercise.sumOfAllArrayElements( dataEx1 );
                        break;
                    case '2':
                        int[][] dataEx2 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] rowSums = exercise.sumOfEachRow( dataEx2 );
                        break;
                    case '3':
                        int[][] dataEx3 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] colSums = exercise.sumOfEachColumn( dataEx3 );
                        break;
                    case '4':
                        int[][] dataEx4 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] maxMin = exercise.maxAndMinElements( dataEx4 );
                        break;
                    case '5':
                        int[][] dataEx5 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        int[] largestInRow = exercise.largestElements( dataEx5 );
                        break;
                    case '6':
                        int[][] dataEx6 = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
                        exercise.reversalOfElementsInEachRow( dataEx6 );
                        break;
                    case '7':
                        int[][] imageEx7 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] easySmooth = exercise.imageSmootherEasy( imageEx7 );
                        break;
                    case '8':
                        int[][] imageEx8 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] hardSmooth = exercise.imageSmootherHard( imageEx8 );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                            done = true;
                        else
                            System.out.print( "Invalid Choice" );
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
