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
    
    //to be continued ............
    
    
    
