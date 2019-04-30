import java.io.*;
import java.util.*;

/**
 * This program takes input from a file, and outputs a list of countries and population, sorted alphabetically, and sorted by population.
 * 
 * @author Peter Lin
 * @version 1.0 04-03-19
 */

public class Countries
{
    final static String multiWordCountries[] = {"Antigua and Barbuda", "Bosnia and Herzegovina", "Burkina Faso", "Cape Verde", "Central African Republic", "Congo, Republic of", "Congo, Democratic Republic of the", "Costa Rica", "Czech Republic", "Dominican Republic", "East Timor", "El Salvador", "Equatorial Guinea", "Korea, North", "Korea, South", "Marshall Islands", "Myanmar (Burma)", "New Zealand", "Papua New Guinea", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and the Grenadines", "San Marino", "Sï¿½o Tomï¿½ and Prï¿½ncipe", "Saudi Arabia", "Sierra Leone", "Solomon Islands", "South Africa", "Sri Lanka", "Trinidad and Tobago", "United Arab Emirates", "United Kingdom", "United States"};

    static String[] countries, capitals, area, population;

    /**
     * This method sorts the countries and population arrays by the country's alphabetical order.
     */
    private static void sortByCountry ()
    {
	for (int i = 0 ; i < 195 ; i++)
	{
	    for (int j = 0 ; j < 194 - i ; j++)
	    {
		if (countries [j].compareTo (countries [j + 1]) > 0)
		{
		    //swapping the elements
		    String temp = population [j];
		    population [j] = population [j + 1];
		    population [j + 1] = temp;

		    temp = countries [j];
		    countries [j] = countries [j + 1];
		    countries [j + 1] = temp;
		}
	    }
	}
    }

    /**
     * This method sorts the countries and population arrays by the country's population.
     */
    private static void sortByPopulation ()
    {
	for (int i = 0 ; i < 195 ; i++)
	{
	    for (int j = 0 ; j < 194 - i ; j++)
	    {
		if (population [j].length () == population [j + 1].length () ? population [j].compareTo (population [j + 1]) < 0:
		population [j].length () < population [j + 1].length ())
		{
		    //swapping the elements
		    String temp = population [j];
		    population [j] = population [j + 1];
		    population [j + 1] = temp;

		    temp = countries [j];
		    countries [j] = countries [j + 1];
		    countries [j + 1] = temp;
		}
	    }
	}
    }

    /**
     * This is the driver method that runs the program.
     * 
     * @param args the command line arguments.
     * @throws IOException if an IOException occurs.
     */
    public static void main (String[] args) throws IOException
    {
	BufferedReader br = new BufferedReader (new FileReader ("Countries-Population.txt"));
	countries = new String [195];
	capitals = new String [195];
	area = new String [195];
	population = new String [195];
	String line;
	int edgeCaseNumber = 0;
	for (int i = 0 ; (line = br.readLine ()) != null ; i++)
	{
	    if (line.contains ("Vatican City"))
	    {
		countries [i] = "Vatican City";
		capitals [i] = " ";
		area [i] = "0.17";
		population [i] = "932";
	    }
	    else if (line.contains ("Western Sahara"))
	    {
		countries [i] = "Western Sahara";
		capitals [i] = " ";
		area [i] = "102,703";
		population [i] = "278,600";
	    }
	    else if (i == 41){
		countries [i] = "Côte d'Ivoire";
		capitals [i] = "Yamoussoukro";
		area[i] = "124,502";
		population[i] = "17,654,843";
	    }
	    else if (edgeCaseNumber < multiWordCountries.length && line.contains (multiWordCountries [edgeCaseNumber]))
	    {
		countries [i] = multiWordCountries [edgeCaseNumber++];
		StringTokenizer st = new StringTokenizer (line.substring (countries [i].length ()), " ");
		StringBuilder sb = new StringBuilder (st.nextToken ());
		while (st.countTokens () > 2)
		{
		    sb.append (' ').append (st.nextToken ());
		}
		capitals [i] = sb.toString ();
		area [i] = st.nextToken ();
		population [i] = st.nextToken ();
	    }
	    else
	    {
		StringTokenizer st = new StringTokenizer (line, " ");
		countries [i] = st.nextToken ();
		StringBuilder sb = new StringBuilder (st.nextToken ());
		while (st.countTokens () > 2)
		{
		    sb.append (' ').append (st.nextToken ());
		}
		capitals [i] = sb.toString ();
		area [i] = st.nextToken ();
		population [i] = st.nextToken ();
	    }
	    System.out.println(line);
	}
	System.out.println(Arrays.toString(countries));
	//sort the countries by name
	sortByCountry ();
	PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter ("sortedByCountry.txt")));
	for (int i = 0 ; i < countries.length ; i++)
	{
	    pw.printf ("%-36s %s\n", countries [i], population [i]);
	}
	pw.close ();

	//sort the countries by population
	sortByPopulation ();
	pw = new PrintWriter (new BufferedWriter (new FileWriter ("sortedByPopulation.txt")));
	for (int i = 0 ; i < countries.length ; i++)
	{
	    pw.printf ("%-36s %s\n", countries [i], population [i]);
	}
	pw.close ();
    }
}
