public class Node {
	
	private Song song; 
	Node next;
	
	/**INPUT: a Song object
	 * PROCESS: initilizes the Node
	 * OUTPUT: returns a new Node
	 * */
	public Node(Song s) {
		song = s;
	}
	
	/**INPUT: None
	 * PROCESS: "gets" the song required for the Node
	 * OUTPUT: returns the song
	 * */	
	public Song getSong() {
		return song;
	}
	
	/**INPUT: None
	 * PROCESS: returns the next node
	 * OUTPUT: the next node
	 * */
	public Node getNext() {
		return next;
	}
	
	/**INPUT: None
	 * PROCESS: return a new Node containing Song object
	 * OUTPUT: the new Node
	 * */
	public Node getNode() {
		return new Node(song);
	}
}

public class Song {
	
	private String title; 
	private String artist;
	
	/**INPUT: Strings t & a
	 * PROCESS: initilize the state 
	 * OUTPUT: noething
	 * */
	public Song(String t, String a) {
		title = t; 
		artist = a;
	}
	
	/**INPUT: none
	 * PROCESS: initilize song title
	 * OUTPUT: nothing
	 * */
	public void setTitle(String t) {
		title = t;
	}
	
	/**INPUT: none
	 * PROCESS: initialize song artist
	 * OUTPUT: nothing
	 * */
	public void setArtist(String a) {
		artist = a;
	}
	
	/**INPUT: none
	 * PROCESS: returns initialized song title
	 * OUTPUT: returns song title
	 * */
	public String getTitle() {
		return title;
	}
	
	/**INPUT: none
	 * PROCESS: returns initialized song artist
	 * OUTPUT: returns song artist
	 * */
	public String getArtist() {
		return artist;
	}
	
	/**INPUT: none
	 * PROCESS: instantiates a Song object from title and artist
	 * OUTPUT: returns new Song
	 * */
	public Song getSong() {
		return new Song(title, artist);
	}
}

public class LinkedList {
	
	private Node head; 
	private Node tail; 
	private int size; 
	
	/**INPUT: none
	 * PROCESS: creates empty linkedlist
	 * OUTPUT: returns that linkedlist
	 * */		
	public LinkedList() {
		size = 0;
	}
	
	/**INPUT: none
	 * PROCESS: returns the head Node
	 * OUTPUT: head Node
	 * */	
	public Node getHead() {
		return head;
	}
	
	/**INPUT: none
	 * PROCESS: returns the tail Node
	 * OUTPUT: tail Node
	 * */
	public Node getTail() {
		return tail;
	}
	
	/**INPUT: none
	 * PROCESS: returns Node after head Node
	 * OUTPUT: next Node
	 * */
	public Node getNext(){
		return getHead().next;
	}
	
	/**INPUT: none
	 * PROCESS: returns size of LL
	 * OUTPUT: size
	 * */
	public int getSize() {
		return size;
	}
	
	/**INPUT: none
	 * PROCESS: checks for "incoming" nodes
	 * OUTPUT: returns true or false
	 * */
	public boolean hasNext() { 
		if(getHead() == null || getNext() == null)
			return false;
		else return true;
	}
	
	/**INPUT: current Node
	 * PROCESS: adds a new Node to the list
	 * OUTPUT: none
	 * */
	public void add(Node current) {
		if (tail != null) {
			tail.next = current;
			tail = current;
		}
		else current = tail;
	}
	
	/**INPUT: index
	 * PROCESS: deletes an LL node at the specified index
	 * OUTPUT: none
	 * */
	public void delete(int index) {
		if(index != -1) tail = tail.next;
		else head = head.next;
	}
}

public class SongHistoryList {
	
	private LinkedList history;
	
	/**INPUT: none
	 * PROCESS: initializes the LL's instance
	 * OUTPUT: returns that LL
	 * */
	public SongHistoryList() {
		history = new LinkedList();
	}	
	
	/**INPUT: a song Node
	 * PROCESS: adds the song Node
	 * OUTPUT: none
	 * */
	public void addSong(Node song) {
		history.add(song);
	}
	
	/**INPUT: index
	 * PROCESS: LL deletes element at index
	 * OUTPUT: none
	 * */
	public void delete(int index) {
		if(history != null)
			history.delete(index);
	}
	
	/**INPUT: none
	 * PROCESS: creates the LL after deletion and insertion
	 * OUTPUT: returns the LL
	 * */
	public LinkedList getSongHist() {
		return history; 
	}
}

public class PlayList {
	
	private LinkedList songList;
	private static SongHistoryList historyPointer = new SongHistoryList();
	private Node current;
	
	/**INPUT: none
	 * PROCESS: initializes LL
	 * OUTPUT: returns that LL
	 * */
	public PlayList() {
		songList = new LinkedList();
	}
	
	/**INPUT: none
	 * PROCESS: returns a songHistoryList
	 * OUTPUT: songHistoryList
	 * */
	public SongHistoryList getHistList() {
		return historyPointer;
	}
	
	/**INPUT: a String song name
	 * PROCESS: searches for the song given title
	 * OUTPUT: returns the song if found or null
	 * */
	public Song findSong(String name) {
		current = songList.getHead();
		while(current != null) {
			if (current.getSong().getTitle().equals(name))
				return current.getSong();
			current = current.getNext();
		}
		return null;
	}
	
	/**INPUT: none
	 * PROCESS: "plays" the next song
	 * OUTPUT: returns it
	 * */
	public Node nextSong() throws Exception {
		historyPointer.addSong(current);
		current = current.getNext();
		if (current == null) throw new Exception("No next song");
		return current;
	}
	
	/**INPUT: none
	 * PROCESS: creates the songlish after adding elements
	 * OUTPUT: the songlist 
	 * */
	public LinkedList getSongList() {
		return songList;
	}
}

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class QueueArray {
	
	private static final int size = 4;
	String fileData[];
	String titles[] = new String [size];
	String artists[] = new String [size];
	private int rear = 0;
	private Scanner input;
	
	/**INPUT: A String of fileName
	 * PROCESS: inputs the titles and artists from the text files
	 * OUTPUT: they get inserted into the QueueArray
	 * */
	public QueueArray(String f) throws Exception{
		input = new Scanner(new File(f));
		fileData = new String[size]; int i = 0;
		while(i < size) {
			fileData[i] = input.nextLine(); 
			String [] temp = fileData[i].split(",");
			titles[i] = temp[0];
			artists[i] = temp[1];
			i++;
		}
	}
	
	/**INPUT: none
	 * PROCESS: returns an array of song titles
	 * OUTPUT: titles
	 * */
	public String[] getTitles( ) {
		return titles;
	}
	
	/**INPUT: none
	 * PROCESS: returns an array of song artists
	 * OUTPUT: artists
	 * */
	public String[] getArtists() {
		return artists;
	}
	
	/**INPUT: String song
	 * PROCESS: adds an element to the QueueArray at rear
	 * OUTPUT: none
	 * */
	public void enque(String song) {
		if (rear == size - 1) 
			System.out.println("Full queue; remove some songs");
		fileData[rear] = song; rear++;
	}
	
	/**INPUT: none
	 * PROCESS: removes an element from QueueArray from front
	 * OUTPUT: the song removed
	 * */
	public String deque() {
		if (rear == 0) 
			System.out.println("Empty queue; add some songs");
		String song = fileData[0];
		for (int i = 0; i < rear - 1; i++) {
			fileData[i] = fileData[i + 1];
		}
		rear--; return song;
	}
	
	/**INPUT: QueueArrays q1 & q2
	 * PROCESS: merges the titles in ascending order
	 * OUTPUT: resulting merged titles QueueArray
	 * */
	public static Object[] mergeQT(QueueArray q1, QueueArray q2){
		return Stream.concat(Arrays.stream(q1.getTitles()), Arrays.stream(q2.getTitles())).toArray();
	}
	
	/**INPUT: QueueArrays q1 & q2
	 * PROCESS: merges the artist names in ascending order
	 * OUTPUT: resulting merged artists QueueArray
	 * */
	public static Object[] mergeQA(QueueArray q1, QueueArray q2){
		return Stream.concat(Arrays.stream(q1.getArtists()), Arrays.stream(q2.getArtists())).toArray();
	}
}

public class StackArray {
	
	private static final int max = 12; static int top; 
	static Object [] songs = new String [max];
	
	/**INPUT: Object songlist array 
	 * PROCESS: adds the songs elements to list
	 * OUTPUT: new StackArray
	 * */
	public StackArray(Object [] list) {
		for(int i = 0; i < list.length; i++) {
			top = i; 
			songs[top] = list[top];
		}
	}
	
	/**INPUT: the song element
	 * PROCESS: checks to see if there's space to add a new song 
	 * OUTPUT: returns true if song is inserted or false otherwise
	 * */
	public boolean addSong(String element) {
		if (top >= max - 1) {
			System.out.println("Stack Oveflow");
			return false;
		} else {
			songs[top++] = element;
			System.out.println("Pushed onto stack");
			return true;
		}
	}
	
	/**INPUT: none
	 * PROCESS: searches for the last listened song
	 * OUTPUT: last listened song
	 * */
	public static Object getLastListened() {
		if (top < 0){
			System.out.println("Stack Underflow");
			return null;
		} else {
			Object x = songs[top--];
			return x;
		}
	}
}
