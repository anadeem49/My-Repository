//MAP.JAVA

import java.util.*;

public class Map extends TreeMap<String, String>{
	
	private static String movieTitle;
	private static String releaseYear;
	private static Map treemap; 

	/**INPUT: the instance 
	 * PROCESS: initilizes the instance
	 * OUTPUT: returns a new Map
	 * */
	public Map(String name, String year) {
		movieTitle = name;
		releaseYear = year;
	}
	
	/**INPUT: None
	 * PROCESS: gets the Key of the Map
	 * OUTPUT: the movie title
	 * */	
	public String getKey() {
		return movieTitle;
	}
	
	/**INPUT: None
	 * PROCESS: gets the Value of the map
	 * OUTPUT: the movie release year
	 * */
	public String getValue() {
		return releaseYear;
	}
	
	/**INPUT: None
	 * PROCESS: Formats the key-value pairs into a String
	 * OUTPUT: The formatted String
	 * */
	public String toString() {
		return "{" + getKey() + "=" + getValue() + "}";
	}
	
	/**INPUT: None
	 * PROCESS: return a new Map containing Map
	 * OUTPUT: the new Map
	 * */
	public static Map create() {
		treemap = new Map(movieTitle, releaseYear);
		return treemap;
	}
	
	/**INPUT: None
	 * PROCESS: Prints the treemap's contents
	 * OUTPUT: None
	 * */
	public static void print() {
		System.out.println(treemap.toString());
	}
}

//MAIN.JAVA

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		/**I used the Map to do this assignment, because I felt that because the
		 * Map readily holds key-value pairs, I wouldn't need the Movie node to hold 
		 * movieTitle and yearReleased and then store that node in a Binary Tree. One
		 * obstacle I had trouble overcoming were the subMaps; though it was a method
		 * in the Map class, implementing it was kind of tough because it wasn't properly
		 * working for the data in textFile.  
		 * */
		
		Scanner file = new Scanner (new File("movies.txt"));
		String movie = "", title = "", year = "";
		String [] parts = new String [2]; Map map = Map.create();
		SortedMap<String, String> sub = null, sub1 = null, sub2 = null;	
		System.out.println("Printing Full Map:");
		
		while(file.hasNextLine()) {
			movie = file.nextLine(); 
			parts = movie.split(", ");
			title =  parts[0]; year = parts[1]; 
			map = new Map(title, year); 
			map.put(title, year); map.print();
			sub = map.subMap("Andrew Dice Clay: Dice Rules, 1991", "Black Butler: Book of the Atlantic, 2017");
			sub1 = map.subMap("Bungo Stray Dogs: Dead Apple, 2018", "Gintama: The Movie, 2010");
			sub2 = map.subMap("Jon Stewart Has Left the Building, 2015", "Silver Spoon, 2014");
		}
		
		System.out.println("\nPrinting 3 subMaps:");
		System.out.print("sub: " + sub.toString() + "\n" + "sub1: " + sub1.toString() 
		+ "\n" + "sub2: " + sub2.toString()); file.close();
	}
}
