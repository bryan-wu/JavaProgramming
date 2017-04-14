import java.text.DecimalFormat;
import java.util.*;
import java.io.*;


/**
 * Chapter 84 - Writing Text Files.
 * 
 * @author Bryan Wu
 * @version 5/2/15
 * 
 * @author Period - 7
 * @author Assignment - Ch84Ex7LetterFrequencies
 * 
 * @author Sources - None
 */
class Ch84Ex7LetterFrequencies
{
    private String sourceName;
    
    private String destName;

    private BufferedReader source;

    private PrintWriter dest;


    /**
     * @param source
     *            source
     * @param dest
     *            dest
     */
    Ch84Ex7LetterFrequencies( String source, String dest )
    {
        sourceName = source;
        destName = dest;
    }


    /**
     * Opens source for reading and dest for writing
     * 
     * @return true if files open, else false
     */
    public boolean openFiles()
    {
        // open the source
        try
        {
            source = new BufferedReader( new FileReader( sourceName ) );
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem opening " + sourceName );
            return false;
        }
        // open the destination
        try
        {
            dest = new PrintWriter( new BufferedWriter( 
                new FileWriter( destName ) ) );
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem opening " + destName );
            return false;
        }
        return true;
    }


    /**
     * Transfer data from source to dest
     */
    public void copyFiles()
    {
        long[] alphabetCount = new long[26];
        int inx;
        int total = 0;
        int letter;
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        double percentage;
        try
        {
            while ( ( letter = source.read() ) != -1 )
            {
                // A-Z
                if ( letter >= 65 && letter <= 90 )
                {
                    inx = letter - (int)'A';
                    alphabetCount[inx]++;
                    total++;
                }

                // a-z
                if ( letter >= 97 && letter <= 122 )
                {
                    inx = letter - (int)'a';
                    alphabetCount[inx]++;
                    total++;
                }

            }
            dest.println( "Total alphabetical characters:\t" + total );
            dest.println();
            for ( int j = 0; j < 26; j++ )
            {
                percentage = ( (double)( alphabetCount[j] ) /
                                (double)( total ) ) * 100;
                // dest.println( alphabet[j] + ":\t" + alphabetCount[j] + "\t"
                // + new DecimalFormat( "#0.00" ).format( percentage ) + "%" );
                dest.printf( "%-10s %-10s %-10s\n",
                    alphabet[j] + ":",
                    alphabetCount[j],
                    new DecimalFormat( "#0.00" ).format( percentage ) + "%" );
            }
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem reading or writing" );
        }
    }


    /**
     * Close the output file
     */
    public void closeFiles()
    {
        // close the source
        try
        {
            source.close();
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem closing " + sourceName );
        }
        // close the destination
        dest.close();
    }


    /**
     * Instantiates a Ch84Ex7LetterFrequencies object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );

        System.out.print( "Enter Source Filename -->" );
        String srcFileName = scan.nextLine().trim();

        System.out.print( "Enter Destination Filename -->" );
        String destFileName = scan.nextLine().trim();

        Ch84Ex7LetterFrequencies cp = new Ch84Ex7LetterFrequencies( srcFileName
            , destFileName );
        if ( cp.openFiles() )
        {
            cp.copyFiles();
            cp.closeFiles();
        }
    }
}