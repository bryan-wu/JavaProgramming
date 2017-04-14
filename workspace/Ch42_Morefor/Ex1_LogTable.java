import java.io.*;


/**
 * Prints out a table of x and ln(x) so that the table is formatted using HTML.
 * A web page is created by first printing:
 * 
 * <html> <body>
 * <table cellspacing=10>
 * <tr>
 * <th>x</th>
 * <th>ln(x)</th>
 * </tr>
 * 
 * Next, for each iteration of the loop, x and log(x) are calculated and the
 * following line is printed:
 * 
 * "
 * <tr>
 * <td>" + x + "</td>
 * <td>" + Math.log(x) + "</td>
 * </tr>
 * "
 * 
 * The web page is finalized by printing:
 * 
 * </table>
 * </body> </html>
 * 
 * TWhen run the program writes the output to a disk file named myLogs.html.
 * 
 * @author Bryan Wu
 * @version 12/11/14
 * @author Period - 7
 * @author Assignment - Ex1_LogTable
 * @author Sources - none
 */
public class Ex1_LogTable
{

    @SuppressWarnings("resource")
    public static void main( String[] args ) throws IOException
    {

        File file = new File( "LogTable.html" ); // preparing output file
        PrintStream print = null;
        print = new PrintStream( file );
        print.print( "<html> <body>" );
        print.print( "<table cellspacing=10>" );
        print.print( "<tr>" );
        print.print( "<th>x</th>" );
        print.print( "<th>ln(x)</th>" );
        print.print( "</tr>" );

        for ( int j = 1; j <= 20; j++ )
        {
            double x = j / 10.0;
            print.print( "<tr>" );
            print.print( "<td>" + x + "</td>" );
            print.print( "<td>" + Math.log( x ) + "</td>" );
            print.print( "</tr>" );
        }
        print.print( "</table>" );
        print.print( "</body> </html>" );

        print.close();
    }
}