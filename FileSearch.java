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
 * Description: Create a program to approximate how many jelly beans are in a jar
 *
 * Inputs: Equatrial Diameter (d), Polar Diameter (l), Jar Size (s)
 *
 * Output: "There are approximately (#ofjellybeans) beans in the jar"
 *
 ***************************************************************************/
import java.util.Scanner;
import java.io.*;
public class FileSearch
{
  public static void main(String[] args) throws FileNotFoundException{
    /*
     * User Input of file name and search term
     */
    System.out.println("Enter the name of the file ");
    Scanner fileName = new Scanner(System.in);
    
    Scanner keyboard = new Scanner(System.in);
    
    String filename = keyboard.nextLine();
    File file = new File(filename);
    Scanner inputFile = new Scanner(file);
    
    System.out.println("Enter the search term");
    Scanner userInput = new Scanner(System.in);
  
      
    while(inputFile.hasNext()){
         String line = inputFile.nextLine();
         if(line.contains(userInput)){
             System.out.println(line);
         }
    }

    System.out.println();
  }
}
    