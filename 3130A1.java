import java.io.*;
import java.util.*;

public class StreamingArtists {
	
	/**INPUT: This method takes in a Scanner "file" object, a 2D String array, and its rows and columns
	 * PROCESS: It inputs the data from the CSV files into the 2d array
	 * OUTPUT: Doesn't return any output, but calls printArray to print out the 2d array
	 * */
	public static void input(Scanner file, int rows, int columns, String[][] songs){
		songs = new String [rows][columns];
		for (int i = 0; i < rows; i++) {
			String split [] = file.nextLine().split(",");
			for (int j = 0; j < columns; j++) {
				songs[i][j] = split[j];
			}
		}
		printArray(songs, rows, columns);
	}
	
	/**INPUT: This method takes in the 2d String called songs and its rows and columns
	 * PROCESS: This method prints out the 2d array
	 * OUTPUT: This method doesn't return an output
	 * */
	public static void printArray(String [][] songs, int rows, int columns) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(songs[i][j]);
			}
			System.out.println();
		}
	}
	
	/**INPUT: The main method always takes in a String array called "args"
	 * PROCESS: This "driver" method tests out the above methods 
	 * OUTPUT: It doesn't return any output
	 * */
	public static void main(String[] args) throws Exception{
		Scanner file = new Scanner(new File("names.txt"));
	    int rows = 5, columns = 3;
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

public class TopStreamingArtists extends StreamingArtists{
	
	private static String[] songs = new String [15];	
	private static LinkedList <String> ordered = new LinkedList<String>();
	private static String data; private static Node next;
	
	/**INPUT: This method takes in a Scanner object called "text"
	 * PROCESS: It inserts the data into the LinkedList from the CSV in ascending order
	 * OUTPUT: It returns a fully loaded LinkedList containing String data
	 * */
	public static LinkedList<String> insert (Scanner text) {
		while(text.hasNextLine()) { 
			data = text.nextLine();
			String [] split = data.split(",");
			int n = ordered.size();
			if (n == 0) {
				ordered.add(data);
			} else if (ordered.get(0).compareTo(split[1]) > 0) {
				ordered.add(0, data);
			} else if (ordered.get(n - 1).compareTo(split[1]) < 0) {
				ordered.add(n, data);
			} else {
				int i = 0;
				while (ordered.get(i).compareTo(split[1]) < 0) {
					i++;
				}
				ordered.add(i, data);
			}
		}	
		System.out.print(ordered);
		return ordered;
	}
	
	/**INPUT: This method takes in a Scanner object called "text"
	 * PROCESS: This method hopes to split the data in the LL after every 3rd comma
	 * OUTPUT: It "hopes" to return the split up version of the LL
	 * */
	public static LinkedList<String> split(Scanner file) {
		int count = 0, pos = 0; 
		for(int i = 0; i < ordered.size(); i++) {
			data = file.nextLine();
			if (ordered.get(i).contains(",")) {
				count++; pos++;
				if (count == 3 && pos == 3) {
					songs = data.split(",");
					count = 0; pos = 0;
				}
			}
			ordered = (LinkedList<String>) Arrays.asList(songs);
		}
		//ordered = (LinkedList<String>) Arrays.asList(songs);
		return ordered;
	}
	
	/**INPUT: The main method always takes in a String array called "args"
	 * PROCESS: This "driver" method tests out the above methods
	 * OUTPUT: It doesn't return any output
	 * */
	public static void main(String[] args) throws Exception{
		Scanner file = new Scanner(new File("names.txt"));
		ordered = insert(file); ordered = split(file);
	}
}
