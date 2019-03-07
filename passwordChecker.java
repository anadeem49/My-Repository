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
      
      if(testPassword(password)){
        System.out.println("You entered " + password);
        System.out.println("Password is valid");
      }
      else{ 
        System.out.pritnln("You entered " + password);
        System.out.println("Password is invalid");
      }
    }
    System.out.println("The program is finished");
    infile.close();
  }
  
//I: String password
//P: Test its length, whether it hs upper/lower case letters and digits
//O: Return a boolean called valid to the main
  public static boolean testPassword(String password) throws IOExeception{
    boolean hasUpperCase = password.equals(password.toUpperCase());
    boolean hasLowerCase = password.equals(password.toLowerCase());
    boolean valid = false;
    if (password.length()) >= 8){
      valid = true;
    if (password.matches("[0 - 9]"))
      valid = true;
    if (password.indexOf(" ") == -1)
      valid = true;
    if (hasUpperCase && hasLowerCase)
      valid = true;
    else
      valid = false;
    }
    return valid;
  }
}
