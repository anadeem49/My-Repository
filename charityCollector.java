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
  public
      
    
    
    
    
    
