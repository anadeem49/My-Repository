import java.util.*;

public class HashMap extends TreeMap<String, String>{
	
	private static String movieTitle, movieGenre;
	private static HashMap hashmap; 

	/**INPUT: the instance 
	 * PROCESS: initilizes the instance
	 * OUTPUT: returns a new Map
	 * */
	public HashMap(String name, String type) {
		movieTitle = name;
		movieGenre = type;
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
	 * OUTPUT: the movie genre
	 * */
	public String getValue() {
		return movieGenre;
	}
	
	/**INPUT: None
	 * PROCESS: Formats the key-value pairs into a String
	 * OUTPUT: The formatted String
	 * */
	public String toString() {
		return "{" + getKey() + " = " + getValue() + "}";
	}
	
	/**INPUT: None
	 * PROCESS: Creates a new HashMap with the required parameters
	 * OUTPUT: the hashmap
	 * */
	public static HashMap create() {
		hashmap = new HashMap(movieTitle, movieGenre);
		return hashmap;
	}
	
	/**INPUT: None
	 * PROCESS: prints the hashmap by invoking toString 
	 * OUTPUT: None
	 * */
	public static void print() {
		System.out.println("\n" + hashmap.toString());
	}
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		/**My biggest challenge was getting the counters to print
		 * the total values of the movies once. Also from the larger CSV
		 * file, I was only able to find 17 movies from the last 5 years.
		 * Other than that, I did my best :)
		 * */
				
		Scanner file = new Scanner (new File("file.text"));
		String movie = "", title = "", genre = "", year = ""; 
		
		int countThrill = 0, countDoc = 0, countCom = 0, countCrime = 0, total = 17;
		int countHorror = 0, countAct = 0, countWar = 0, countDra = 0, countAdv = 0;
		int for2014 = 0, for2016 = 0, for2017 = 0, for2018 = 0;
		
		double avgThrill = 0, avgDoc = 0, avgCom = 0, avgCrime = 0;
		double avgHorror = 0, avgAct = 0, avgWar = 0, avgDra = 0, avgAdv = 0;		
				
		String [] parts = new String [2]; HashMap hashmap = HashMap.create();
		System.out.println("Printing Full Map:");
		
		while(file.hasNextLine()) {
			movie = file.nextLine(); 
			parts = movie.split("\t");
			title =  parts[0]; genre = parts[1];
			hashmap = new HashMap(title, genre); 
			hashmap.put(title, genre); HashMap.print();
			year = movie.substring(movie.indexOf("(") + 1, movie.indexOf(")"));
			
	/*1*/	if (genre.equalsIgnoreCase("thriller")) { 
				countThrill++;
				System.out.println("There are " + countThrill + " thrillers");
				avgThrill = (double) countThrill/total;
				System.out.println("Average thrillers: " + avgThrill);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*2*/	} if (genre.equalsIgnoreCase("documentary")) {
				countDoc++;
				System.out.println("There are " + countDoc + " documentaries");
				avgDoc = (double) countDoc/total;
				System.out.println("Average documentaries: " + avgDoc);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*3*/	} if (genre.equalsIgnoreCase("comedy")) {
				countCom++;
				System.out.println("There are " + countCom + " comedies");
				avgCom = (double) countCom/total;
				System.out.println("Average comedies: " + avgCom);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*4*/	} if (genre.equalsIgnoreCase("crime")) { 					
				countCrime++;
				System.out.println("There are " + countCrime + " crime movies");
				avgCrime = (double) countCrime/total;
				System.out.println("Average crime movies: " + avgCrime);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*5*/	} if (genre.equalsIgnoreCase("horror")) {
				countHorror++;					
				System.out.println("There are " + countHorror + " horror movies");
				avgHorror = (double) countHorror/total;
				System.out.println("Average horror movies: " + avgHorror);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*6*/	} if (genre.equalsIgnoreCase("action")) {
				countAct++;
				System.out.println("There are " + countAct + " action movies");
				avgAct = (double) countAct/total;
				System.out.println("Average action movies: " + avgAct);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*7*/	} if (genre.equalsIgnoreCase("war")) { 
				countWar++;
				System.out.println("There are " + countWar + " war movies");
				avgWar = (double) countWar/total;
				System.out.println("Average war movies: " + avgWar);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*8*/	} if (genre.equalsIgnoreCase("drama")) {
				countDra++;
				System.out.println("There are " + countDra + " dramas");
				avgDra = (double) countDra/total;
				System.out.println("Average dramas: " + avgDra);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
				
	/*9*/	} if (genre.equalsIgnoreCase("adventure")) {
				countAdv++;
				System.out.println("There are " + countAdv + " adventure movies");
				avgAdv = (double) countAdv/total;
				System.out.println("Average adventure movies: " + avgAdv);
				if (year.equals("2014")) {
					for2014++; 
					System.out.println(for2014 + " movies for 2014");
				}
				if (year.equals("2016")) {
					for2016++;
					System.out.println(for2016 + " movies for 2016");
				}
				if (year.equals("2017")) {
					for2017++;
					System.out.println(for2017 + " movies for 2017");
				}
				if (year.equals("2018")) {
					for2018++;
					System.out.println(for2018 + " movies for 2018");
				}
			}
		}
		file.close();
	}
}
