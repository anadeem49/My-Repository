/*This is my java project that
*tests the valdity of passwords in an input file*/

import java.util.Scanner;
import java.io.*;

public class passwordCheck{
  
  public static void main (String[] args) throws IOException{
    
    Scanner infile = new Scanner(new File("input.txt"));
    
    String password;
    
    while(infile.hasNextLine()){
      
      password = infile.nextLine();
      
      if(testPassword

  
