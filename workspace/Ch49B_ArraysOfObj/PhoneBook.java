/**
 * 
 * 
 * @author Bryan Wu
 * @version 1/16/15
 * @author Period - 7
 * @author Assignment - Ch49B_PhoneBook
 * @author Sources - none
 */
public class PhoneBook
{
    private PhoneEntry[] phoneBook;

    private int nextEntry;


    /**
     * Constructs a phonebook with a capacity of 25 entries and initializes the
     * first 10 entries.
     */
    public PhoneBook() // constructor
    {
        phoneBook = new PhoneEntry[25];

        phoneBook[0] = new PhoneEntry( "Jenny", "Java", "(555)555-5555" );
        phoneBook[1] = new PhoneEntry( "Bob", "Binary", "(101)010-1010" );
        phoneBook[2] = new PhoneEntry( "Olive", "Oyl", "(555)123-4567" );
        phoneBook[3] = new PhoneEntry( "Mycroft", "Holmes", "(555)123-4321" );
        phoneBook[4] = new PhoneEntry( "Lynne", "Brook", "(408)366-7700" );
        phoneBook[5] = new PhoneEntry( "Monty", "Vista", "(408)366-7600" );
        phoneBook[6] = new PhoneEntry( "Cooper", "Tino", "(408)366-7300" );
        phoneBook[7] = new PhoneEntry( "Bertha", "Binary", "(111)111-1111" );
        phoneBook[8] = new PhoneEntry( "Betty", "Binary", "(011)100-0000" );
        phoneBook[9] = new PhoneEntry( "Sara", "Toga", "(408)867-3411 " );

        nextEntry = 10;
    }


    /**
     * Lists out entries of phonebook
     */
    public void print()
    {
        if ( nextEntry <= 0 )
        {
            System.out.println( "Phonebook empty!!" );
        }
        else
        {
            for ( int i = 0; i < nextEntry; i++ )
            {
                System.out.println( phoneBook[i].firstName + " "
                    + phoneBook[i].lastName + " " + phoneBook[i].phoneNum );
            }
        }
    }


    /**
     * Adds a name and phone number entry
     * 
     * @param pEntry
     *            entry
     * @return PhoneEntry
     */
    public PhoneEntry add( PhoneEntry pEntry )
    {
        if ( getNextEntry() != 25 ) // check if phonebook is full
        {
            phoneBook[nextEntry] = pEntry;
            nextEntry++;
            return pEntry;
        }

        return null;

    }


    /**
     * Deletes a name and phone number entry
     * 
     * @param pEntry
     *            entry
     * @return PhoneEntry
     */
    public PhoneEntry delete( PhoneEntry pEntry )
    {

        if ( !pEntry.firstName.equalsIgnoreCase( "" )
            || !pEntry.lastName.equalsIgnoreCase( "" ) )
        {
            for ( int i = 0; i < phoneBook.length; i++ )
            {
                if ( phoneBook[i] != null
                    && phoneBook[i].lastName.equalsIgnoreCase( pEntry.lastName )
                    && phoneBook[i].firstName.equalsIgnoreCase( pEntry.firstName ) )
                {

                    phoneBook[i] = phoneBook[nextEntry - 1];
                    phoneBook[nextEntry - 1] = null;
                    nextEntry--;
                    return pEntry;
                }
            }
        }
        return null;
    }


    /**
     * Search for a name among entries
     * 
     * @param pEntry
     *            ` entry
     * @return PhoneEntry
     */
    public PhoneEntry[] search( PhoneEntry pEntry )
    {

        int matches = 0; // counter for number of matches found
        int singleMatch = 0;// counter for single match
        PhoneEntry[] nameStorage = null;

        if ( pEntry.lastName.equalsIgnoreCase( "" ) // check if nothing entered
            && pEntry.firstName.equalsIgnoreCase( "" ) )
        {
            return null;
        }

        if ( pEntry.firstName.equalsIgnoreCase( "" ) ) // if only last name
                                                       // entered
        {
            for ( int j = 0; j < phoneBook.length; j++ )
            {
                if ( phoneBook[j] != null
                    && phoneBook[j].lastName.equalsIgnoreCase( pEntry.lastName ) )
                {
                    matches++;
                }
            }

            nameStorage = new PhoneEntry[matches]; // create PhoneEntry to
                                                   // hold same number of
                                                   // entries as found in
                                                   // search

            for ( int j = 0; j < phoneBook.length; j++ )
            {
                if ( phoneBook[j] != null
                    && phoneBook[j].lastName.equalsIgnoreCase( pEntry.lastName ) )
                {
                    nameStorage[singleMatch] = phoneBook[j];
                    singleMatch++;
                }
            }
        }

        else
        {
            for ( int j = 0; j < phoneBook.length; j++ )
            {
                if ( phoneBook[j] != null
                    && phoneBook[j].firstName.equalsIgnoreCase( pEntry.firstName )
                    && phoneBook[j].lastName.equalsIgnoreCase( pEntry.lastName ) )
                {
                    nameStorage = new PhoneEntry[1]; // create a phoneEntry to
                                                     // store single match
                    nameStorage[0] = phoneBook[j];
                }
            }
        }
        return nameStorage;
    }


    // ////////////////////////////////////////
    // Methods used for testing purposes only

    protected PhoneEntry[] getPhoneBook()
    {
        return phoneBook;
    }


    protected int getNextEntry()
    {
        return nextEntry;
    }
}