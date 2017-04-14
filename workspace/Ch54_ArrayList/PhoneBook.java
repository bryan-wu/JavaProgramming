import java.util.*;

import javax.swing.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO date
 * @author Period - TODO Your Period
 * @author Assignment - Ch54 ArrayList Phonebook
 * @author Sources - TODO list collaborators
 */
public class PhoneBook
{
    private ArrayList<PhoneEntry> phoneBook;


    /**
     * Constructs a PhoneBook with a default set of PhoneEntry objects contained
     * in a ArrayList
     */
    public PhoneBook()
    {
        phoneBook = new ArrayList<PhoneEntry>( 25 );

        phoneBook.add( new PhoneEntry( "Jenny", "Java", "(555)555-5555" ) );
        phoneBook.add( new PhoneEntry( "Bob", "Binary", "(101)010-1010" ) );
        phoneBook.add( new PhoneEntry( "Olive", "Oyl", "(555)123-4567" ) );
        phoneBook.add( new PhoneEntry( "Mycroft", "Holmes", "(555)123-4321" ) );
        phoneBook.add( new PhoneEntry( "Lynne", "Brook", "(408)366-7700" ) );
        phoneBook.add( new PhoneEntry( "Monty", "Vista", "(408)366-7600" ) );
        phoneBook.add( new PhoneEntry( "Cooper", "Tino", "(408)366-7300" ) );
        phoneBook.add( new PhoneEntry( "Sara", "Toga", "(408)867-3411 " ) );
        phoneBook.add( new PhoneEntry( "Bertha", "Binary", "(111)111-1111" ) );
        phoneBook.add( new PhoneEntry( "Betty", "Binary", "(011)100-0000" ) );

        Collections.sort( phoneBook );
    }


    /**
     * Prints the contents of the PhoneBook. Uses an iterator to traverse the
     * ArrayList
     */
    public void print()
    {
        Iterator<PhoneEntry> iter = phoneBook.iterator();
        while ( iter.hasNext() )
        {
            PhoneEntry pe = iter.next();
            System.out.println( pe );
        }
    }


    /**
     * Returns a copy of this phonebook
     * 
     * @return a copy of this phonebook
     */
    public ArrayList<PhoneEntry> getPhoneBook()
    {
        return new ArrayList<PhoneEntry>( phoneBook );
    }


    /**
     * Appends the specified element to the end of the phonebook.
     * 
     * @param pEntry
     *            a PhoneEntry
     */
    public void add( PhoneEntry pEntry )
    {
        phoneBook.add( pEntry ); // add entry

        Collections.sort( phoneBook );
    }


    /**
     * Removes a single instance of the specified element from this list, if it
     * is present
     * 
     * @param pEntry
     *            PhoneEntry to remove
     * @return the element that was removed from the list, null otherwise
     */
    public PhoneEntry delete( PhoneEntry pEntry )
    {
        PhoneEntry delEntry = null;

        // String firstName = pEntry.getFirstName();
        // String lastName = pEntry.getLastName();

        for ( int j = 0; j < phoneBook.size(); j++ )
        {
            if ( phoneBook.get( j ) // check if last name and first name match
                                    // up
                .getLastName()
                .equalsIgnoreCase( pEntry.getLastName() )
                && phoneBook.get( j )
                    .getFirstName()
                    .equalsIgnoreCase( pEntry.getFirstName() ) )
            {
                phoneBook.remove( j ); // delete if match
                return pEntry;
            }
        }

        return delEntry;
    }


    /**
     * Searches for entries in the PhoneBook that match the given PhoneEnty. If
     * the PhoneEntry contains just the last name, the method goes through the
     * entire list, and adds every match to the list. If the PhoneEntry contains
     * both first and last names, the method will add the first match to the
     * list then stop.
     * 
     * @param pEntry
     *            PhoneEntry to find
     * @return an ArrayList of elements found
     */
    public ArrayList<PhoneEntry> search( PhoneEntry pEntry )
    {
        ArrayList<PhoneEntry> result = new ArrayList<PhoneEntry>();
        int matches = 0;

        if ( pEntry.getFirstName().equalsIgnoreCase( "" ) )
        {
            for ( int j = 0; j < phoneBook.size(); j++ )
            {
                if ( phoneBook.get( j ) // check if last name and first name
                                        // match
                                        // up
                    .getLastName()
                    .equalsIgnoreCase( pEntry.getLastName() )
                    && phoneBook.get( j )
                        .getFirstName()
                        .equalsIgnoreCase( pEntry.getFirstName() ) )
                {
                    matches++;
                }
            }
            for ( int j = 0; j < phoneBook.size(); j++ )
            {
                if ( phoneBook.get( j ) != null
                    && phoneBook.get( j )
                        .getLastName()
                        .equalsIgnoreCase( pEntry.getLastName() ) )
                {
                    result.add( phoneBook.get( j ) );
                }
            }
        }

        else
        {
            for ( int j = 0; j < phoneBook.size(); j++ )
            {
                if ( phoneBook.get( j ) != null
                    && phoneBook.get( j )
                        .getFirstName()
                        .equalsIgnoreCase( pEntry.getFirstName() )
                    && phoneBook.get( j )
                        .getLastName()
                        .equalsIgnoreCase( pEntry.getLastName() ) )
                {
                    result.add( phoneBook.get( j ) );
                }
            }
        }

        return result;
    }
}
