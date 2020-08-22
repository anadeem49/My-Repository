import java.io.*;
import java.util.*;
//Import statements for both classes

public class StreamingArtists {
	
	/**INPUT: This method takes in a Scanner "file" object, a 2D String array, and its rows and columns
	 * PROCESS: It inputs the data from the CSV files into the 2d array
	 * OUTPUT: Doesn't return any output, but calls printArray to print out the 2d array
	 * */
	String[][] songs;
	
	public static String[][] readFileAndGetSongs() {
		Scanner file;
		try {
			file = new Scanner(new File("names.txt"));
		    int rows = 8, columns = 3;
		    String[][] songs = new String[rows][columns];
		    songs = input(file, rows, columns, songs);
		    return songs;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		return new String[0][0];
	}
	public static String[][] input(Scanner file, int rows, int columns, String[][] songs){
		songs = new String [rows][columns];
		for (int i = 0; i < rows; i++) {
			String split [] = file.nextLine().split(",");
			for (int j = 0; j < columns; j++) {
				songs[i][j] = split[j];
			}
		}
		return sortArray(songs);
	}
	
	/**INPUT: This method takes in the 2d String called songs and its rows and columns
	 * PROCESS: This method prints out the 2d array
	 * OUTPUT: This method doesn't return an output
	 * */
	public static void printArray(String [][] songs) {
		for(int i = 0; i < songs.length; i++) {
			for(int j = 0; j < songs[i].length; j++) {
				System.out.print(songs[i][j]);
			}
			System.out.println();
		}
	}
	
	/**INPUT: This method takes in the 2d Songs array
	 * PROCESS: This method uses bubble sort to sort by artist name
	 * OUTPUT: This outputs the sorted array
	 * */
	public static String[][] sortArray(String [] [] songs) {
		for (int i = 0; i < songs.length; i++) {
			for (int j = i + 1; j < songs.length; j++) {
				String[] curr = songs[i];
				String[] next = songs[j];
				String currArtistName = curr[1].split("by ")[1];
				String nextArtistName = next[1].split("by ")[1];
				if (currArtistName.compareTo(nextArtistName) > 0) {
					songs[j] = curr;
					songs[i] = next;
				}
			}
		}
		printArray(songs);
		return songs;
	}
	
	/**INPUT: The main method always takes in a String array called "args"
	 * PROCESS: This "driver" method tests out the above methods 
	 * OUTPUT: It doesn't return any output
	 * */
	public static void main(String[] args) throws Exception{
		Scanner file = new Scanner(new File("names.txt"));
	    int rows = 8, columns = 3;
	    String[][] songs = new String[rows][columns];
	    input(file, rows, columns, songs);
	}
}

import java.io.*;
import java.util.*;

class Node{
	Node next; private String data;
	Node() {data = null; next = null;}
	Node(String data) {this.data = data;}
}

public class TopStreamingArtists {
	
	private static LinkedList <String> ordered = new LinkedList<String>();
	
	/**INPUT: This method takes in a Scanner object called "text"
	 * PROCESS: It inserts the data into the LinkedList from the CSV in ascending order
	 * OUTPUT: It returns a fully loaded LinkedList containing String data
	 * */
	public static LinkedList<String> insert (String [][] songs) {
		for(int i = 0; i < songs.length; i++) {
			for (int j = 0; j < songs[i].length; j++) {
				ordered.add(songs[i][j]);
			}
		}
		System.out.println(ordered);
		return ordered;
	}
	
	/**INPUT: This method takes in a Scanner object called "text"
	 * PROCESS: This method hopes to split the data in the LL after every 3rd comma
	 * OUTPUT: It "hopes" to return the split up version of the LL
	 * */
	public static void printList(LinkedList<String> ordered) {
		for(int i = 0; i < ordered.size(); i++) {
			System.out.println(ordered.get(i));
		}
	}
	
	/**INPUT: The main method always takes in a String array called "args"
	 * PROCESS: This "driver" method tests out the above methods
	 * OUTPUT: It doesn't return any output
	 * */
	public static void main(String[] args) throws Exception{
		Scanner file = new Scanner(new File("names.txt"));
		String[][] songs = StreamingArtists.readFileAndGetSongs();
		insert(songs);
	}
}
