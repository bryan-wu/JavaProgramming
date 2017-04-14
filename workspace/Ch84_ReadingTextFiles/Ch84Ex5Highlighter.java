import java.util.*;
import java.io.*;


/**
 * Chapter 84LASTLABBOOYAH - Writing Text Files.
 * 
 * @author Bryan Wu
 * @version 4/28/15
 * 
 * @author Period - 7
 * @author Assignment - Ch84Ex5Highlighter
 * 
 * @author Sources - None
 */
class Ch84Ex5Highlighter
{

    private String sourceName;

    private String destName;

    private BufferedReader source;

    private PrintWriter dest;

    private ArrayList<String> keywordList;


    /**
     * Constructor of sourceName and destName method.
     * 
     * @param source
     *            source
     * @param dest
     *            destination
     */
    Ch84Ex5Highlighter( String source, String dest )
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
        BufferedReader javaKeywords;
        String keyword;
        keywordList = new ArrayList<String>();
        
        // open and load Java Keywords file into ArrayList
        try
        {
            javaKeywords = new BufferedReader( new FileReader( "JavaKeywords."
                + "txt" ) );
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem opening " + "JavaKeywords.txt" );
            return false;
        }

        try
        {
            keyword = javaKeywords.readLine();
            while ( keyword != null )
            {
                keywordList.add( keyword );
                keyword = javaKeywords.readLine();
            }
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem reading or writing" );
        }

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
     * Transfer data from source to destination
     */
    public void copyFiles()
    {
        String line;
        writeHeader();
        try
        {
            line = source.readLine();
            while ( line != null )
            {
                line = highlightKeywords( line );
                dest.println( line );
                line = source.readLine();
            }
        }
        catch ( IOException iox )
        {
            System.out.println( "Problem reading or writing" );
        }
        writeTrailer();
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
     * Write the HTML header.
     */
    public void writeHeader()
    {
        dest.println( "<html>" );
        dest.println( "<head>" );
        dest.println( "<title>titleVar</title>" );
        dest.println( "</head>" );
        dest.println( "<body>" );
        dest.println( "<pre>" );
    }


    /**
     * Write the HTML trailer.
     */
    public void writeTrailer()
    {
        dest.println( "</pre>" );
        dest.println( "</body>" );
        dest.println( "</html>" );
    }


    /**
     * Highlight Keywords of the file.
     * 
     * @param str
     *            str
     * @return highlightKeywords
     */
    public String highlightKeywords( String str )
    {
        StringTokenizer tok = new StringTokenizer( str, " \t\n\r\f", true );
        String token;
        String result = "";

        while ( tok.hasMoreTokens() )
        {
            token = tok.nextToken();
            if ( token.length() == 1 )
            {
                if ( token.equals( "<" ) )
                {
                    token = "&lt;";
                }
                else if ( token.equals( "&" ) )
                {
                    token = "&amp;";
                }
            }
            else if ( keywordList.contains( token ) )
            {
                token = "<b>" + token + "</b>";
            }
            result = result + token;
        }
        return result;
    }


    /**
     * Instantiates a Ch84Ex5Highlighter object and then invokes each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        String srcFileName = "";
        String destFileName = "";

        Scanner scan = new Scanner( System.in );

        System.out.print( "Enter Source Filename -->" );
        srcFileName = scan.nextLine().trim();

        System.out.print( "Enter Destination Filename -->" );
        destFileName = scan.nextLine().trim();

        Ch84Ex5Highlighter cp = new Ch84Ex5Highlighter( srcFileName,
            destFileName );
        if ( cp.openFiles() )
        {
            cp.copyFiles();
            cp.closeFiles();
        }
    }

}