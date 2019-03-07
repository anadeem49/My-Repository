/*This program inputs an array of idNumbers amd donations
 * and sorts them via selectionSort and bubbleSort, also returning
 * the total donors, total amount donated, the highest and lowest donations.*/

import java.util.Scanner;
import java.io.*;

public class charityCollector{
  public static void main(String[] args) throws IOException{
    File file = new File("input.txt");
    Scanner input = new Scanner(file);
    int[] idNumbers = new int [50];
    double[] donations = new double [50];
    int median = 0;
    double median1 = 0, total = 0;
    int donorCount = readArray(idNumbers, donations, input);
    //return value n from readArray used to initialize donorCount
    System.out.println("Original Array");
    System.out.println("IDs \t Donations");
    printArray(idNumbers, donations, donorCount);
    //print the original array
    System.out.println("Bubble Sort");
    system.out.println("IDs \t Donations");
    printArray(idNumbers, donations, donorCount);
    //print the newly sorted array
    System.out.printf("Donor %d gave the highest donation $%.2f\n", idNumbers[0], donations[0]);
    if((donorCount)%2==1){
      //find median if total arrays is odd
      median = (donorCount-1)/2;
      System.out.printf("Median donation: $%.2f\n", donations[median]);
    }
    
    else{
      //if total arrays is even
      median1 = ((donations[(donorCount-1)/2] + (donations[(donorCount)/2]))/2);
      System.out.printf("Median donation: $%.2f\n", median1);
    }
    
    for(int i = 0; i <= donorCount; i++)
      //total donated
      total += donations[i];
    System.out.printf("Total donators: %d, Total donation amount: $%.2f\n", donorCount, total);
    input.close();
  }
  
  //this method reads the data from the input file in the idNumbers array and the donations array
  public static int readArray(int[] idNumbs, double[] donations, Scanner input1) throws IOException{
    int n = 0;
    while(input1.hasNext){
      idNumbs[n] = input1.nextInt();
      donations[n] = input1.nextDouble();
      n++;
    }
    return n;
  }
  
  //this method prints the arrays in two lines with their appropriate heading
  public static void printArray(int [] id, double [] donations, int [] donorCount){
    for (int i = 0; i < donorCount; i++)
      System.out.println("%d $%.2f\n", id[i], donations[i]);
    System.out.println("\n\n");
  }
  
  //this method takes the two arrays and the donorCount and performs a selection sort && sorts by idNumbs in ascending order
  public static void selectionSort(int [] id, double [] donations, int donorCount){
    for (int pass = 0; pass < donorCount - 1; pass++){
      for (int cand = pass + 1; cand < donorCount; cand++)
        if (id[cand] < id[pass]){
          int temp = id[cand]; //temporary value holder
          double temp1 = donations[cand];
          id[cand] = id[pass];
          donations[cand] = donations[pass];
          id[pass] = temp;
          donations[pass] = temp1;
        }
    }
    return;
  }
  
  //this method takes the two arrays and the donorCount and performs a bubble sort
  //it sorts by donations in descending order
  public static void bubbleSort(int [] id, double [] donations, int donorCount){
    boolean swap;
    do{
      swap = false;
      for (int pos = 0; pos < donorCount - 1; pos++){
        if (donations[pos + 1] > donations[pos]){
          double temp = donations[pos + 1]; //temporary value holder
          int temp2 = id[pos + 1];
          donations[pos + 1] = donations[pos];
          id[pos + 1] = id[pos];
          donations[pos] = temp;
          id[pos] = temp2;
          swap = true;
        }
      }
    }
    while(swap);
    return;
  }
}
