/****************************************************************************
 * Project number: 3
 *
 * Programmer:Chris Hutchison
 *
 * Due Date:2/25/2017
 *
 * CMSC 255 Spring 2017
 *
 * Pledge: I have neither given nor received unauthorized aid on the program.
 *
 * Description: Create a program to ask for a name of a file, open said file, find a search term in said file
 * ,and print out the strings that contain the search term
 *
 * Inputs: File Name (fileName), Search Term(userInput)
 *
 * Output: Strings that contain the user input for Search term in the named document they input
 *
 ***************************************************************************/
import java.util.Scanner;
import java.io.*;
public class FileSearch
{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner scan = new Scanner(System.in);
    /*
     * Programmer's Credentials
     */
    System.out.println("Chris Hutchison");
    System.out.println("CMSC 255 Spring 2017");
    System.out.println("Project Number 3\n");
    /*
     * User Input of File Name
     */
    System.out.println("Enter the name of the file ");
    String fileName = scan.nextLine();
    /*
     * Opening the File
     */ 
    File file = new File(fileName);
    Scanner inputFile = new Scanner(file);
    /*
     * User Input of Search Term
     */ 
    System.out.println("Enter the search term");
    String userInput = scan.next();
  
    /*
     * While loop that Reads document, find the strings that contain the search term, and prints them
     */ 
    int i = 0;
    while(inputFile.hasNext()){
         String line = inputFile.nextLine();
         if(line.contains(userInput)){
             System.out.println(line);
             i++;
         }
    }
    if(i == 0){
       System.exit(1);
    }
    System.out.println("\nThe word \""+userInput+"\" appears "+i+" times in the input file");
    /*
     * Closing the Scanner variables
     */ 
    scan.close();
    inputFile.close();
    
  }
}
    