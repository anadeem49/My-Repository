import java.util.*;
import java.io.*;

public class SortingSearching{
	private static int selectionCompare, selectionSwap, bubbleCompare, bubbleSwap, quickCompare, quickSwap;
	private static final int MAX = 100; 
	private static int [] array = new int [MAX];
	private static int low, high;
	
	public static int [] readFile(String fileName, String heading, Scanner readF) {
		
		array = null; int counter = 0;
		readF = null;

		try{
			readF = new Scanner(new File(fileName));
			heading = readF.nextLine();

			while(readF.hasNextInt()){
				readF.nextInt();
				counter++;
			}
			
			array = new int[counter]; readF.close();
			readF = new Scanner(new File(fileName));
			readF.nextLine();
			
			for(int x = 0; x < counter; x++){
				array[x] = readF.nextInt();
			}
		}
		
		catch(FileNotFoundException e){
			System.out.println("Unable to open the file " + fileName);
		}
		
		readF.close(); return array;
	}
	
	public static int [] bubbleSort(int [] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				bubbleSwap++;
			}
			bubbleCompare++;
		}
		return array;
	}
	
	public static int [] quickSort(int [] array, int low, int high) {
		if (low < high){
			int pi = partition(array, low, high); 
            		quickSort(array, low, pi-1); 
            		quickSort(array, pi+1, high); 
        	}
		return array;
	}
	
	public static int partition(int array[], int low, int high){ 
        	int pivot = array[high];  
        	int i = low - 1; 
        	for (int j=low; j<high; j++){ 
            		if (array[j] <= pivot){ 
                		i++;
                		int temp = array[i]; 
                		array[i] = array[j]; 
                		array[j] = temp;
            		}
            		quickCompare++;
        	}
        	int temp = array[i+1]; 
        	array[i+1] = array[high]; 
        	array[high] = temp; 
        	quickSwap++;
        	return i+1; 
    	}
	
	public static int [] selectionSort(int [] array) {
		selectionCompare = selectionSwap = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i+1; j < array.length - 1; j++)
				if (array[j] < array[min])
					min = j;
			selectionCompare++;
			int temp = array[min]; 
	        	array[min] = array[i]; 
	        	array[i] = temp;
	        	selectionSwap++;
	    	}
		return array;
	}
	
	public static void printSorts() {
		System.out.println(bubbleSort(array));
		System.out.println(quickSort(array, low, high));
		System.out.println(selectionSort(array));
	}
	
	public static void compareSorts() {
		
		if(quickCompare < selectionCompare)
			System.out.println("selection sort uses the most comparisons");
		if(quickCompare < bubbleCompare)
			System.out.println("bubble sort uses the most comparisons");
		else
			System.out.println("quick sort uses the most comparisons");
		if(quickSwap < selectionSwap)
			System.out.println("selection sort has the most swaps");
		if(quickSwap < bubbleSwap)
			System.out.println("bubble sort has the most swaps");
		else
			System.out.println("quick sort has the most swaps");
	}
	
	public static void main(String [] args) throws Exception{
		
		Scanner data = new Scanner(new File("data.txt"));
		Scanner header = new Scanner(new File("header.txt"));
		
		while(header.hasNext()){
			int howMany = header.nextInt(); String heading = header.nextLine(); System.out.println(howMany + " " + heading);
			int [] unsorted = new int[howMany];
			for (int i = 0; i < howMany; i++) {
				unsorted[i] = data.nextInt();
				System.out.print(unsorted[i] + " ");
			}
			System.out.println();
			System.out.println();
			
			int [] unsortedTemp = unsorted;
			
			System.out.println("after bubblesort");
			bubbleSort(unsorted);
			for (int i = 0; i < howMany; i++) {
				System.out.print(unsorted[i] + " ");
			}
			System.out.println();
			System.out.println("The bubble sort has " + bubbleCompare + " comparisons and " + bubbleSwap + " swaps");
			
			unsorted = unsortedTemp;
			
			System.out.println("after quicksort");
						
			quickSort(unsorted, 0, howMany - 1);
			for (int i = 0; i < howMany; i++) {
				System.out.print(unsorted[i] + " ");
			}
			System.out.println();	
			System.out.println("The quick sort has " + quickCompare + " comparisons and " + quickSwap + " swaps");
			
			unsorted = unsortedTemp;
			
			System.out.println("after selection sort");
						
			selectionSort(unsorted);
			for (int i = 0; i < howMany; i++) {
				System.out.print(unsorted[i] + " ");
			}
			System.out.println();	
			System.out.println("The selection sort has " + selectionCompare + " comparisons and " + selectionSwap + " swaps");
			compareSorts();
		}
		
		header.close(); data.close();
	}
}
