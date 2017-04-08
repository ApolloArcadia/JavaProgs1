/****************************************************************************
 * Project number: 4
 *
 * Programmer:Chris Hutchison
 *
 * Due Date:3/18/2017
 *
 * CMSC 255 Spring 2017
 *
 * Pledge: I have neither given nor received unauthorized aid on the program.
 *
 * Description: Program opens a user defined file to read and check the integers read inside of it to be either
 * even, prime, palindrome, or emirp
 * 
 * Inputs: File Name (fileName)
 *
 * Output: Integers read pluse whether they are even, prime, palindrome, and emirp
 *
 ***************************************************************************/
import java.util.Scanner;
import java.io.*;
public class DataAnalysis
{
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    Scanner inputFile = null;
    int dayTemp[] = new int[50];
    char tempComp[] = new char[50];
    int i = 0;
    int sum = 0;
    double avg = 0;
    /*
     * Programmer's Credentials
     */
    //printHeader();
    
    boolean isFile = false;
    //int j = 1;
   // while(j == 1){
      /*
       * User input for file name
       */ 
         while(isFile == false){
           System.out.print("Enter the name of the file (enter exit to exit)");
           String fileName = scan.next();
           if(fileName.equals("exit")){
             System.exit(0);
           }
           File file = new File(fileName);
      
           if(file.exists()){
             inputFile = new Scanner(file);
             isFile = true;
           }
         }
         String monthName = inputFile.next();
         int nums = 0;
         nums = monthNum(monthName);
         i = 0;
         while(i < nums - 2){
           dayTemp[i] = inputFile.nextInt();
          // System.out.println(dayTemp[i]);
           sum += dayTemp[i];
           i++;
         }
         avg = sum / nums;
         i = 0;
         //int high = 0;
         //int low = 0;
         int k = 1;
         int m = 3;
         while(i < nums){
           if(dayTemp[i] > avg){
             if(dayTemp[i + 1] > avg){
               if(dayTemp[i + 2] > avg){
                  tempComp[i] = '+';
                  tempComp[i + 1] = '+';
                  tempComp[i + 2] = '+';
                 m = 3;
                 k = 1;
                 if(k != 0){
                   if(dayTemp[i + m] > avg){
                     tempComp[i + m] = '+';
                     m++;
                   }
                   else{
                     i += m;
                     k = 0;
                   }
                 }
               }
             }
           }
             if(dayTemp[i] < avg){
             if(dayTemp[i + 1] < avg){
               if(dayTemp[i + 2] < avg){
                  tempComp[i] = '-';
                  tempComp[i + 1] = '-';
                  tempComp[i + 2] = '-';
                 m = 3;
                 k = 1;
                 if(k != 0){
                   if(dayTemp[i + m] < avg){
                     tempComp[i + m] = '-';
                     m++;
                   }
                   else{
                     i += m;
                     k = 0;
                   }
                 }
               }
             }
           }

            // if(m == 3){
               i++;  
            // }
         }
      i = 0;  
    System.out.printf("The average temperature for %s was %.2f%n", monthName, avg);
      while(i < nums){
        if(i > 8){
          System.out.println(i + 1+"       "+dayTemp[i]+tempComp[i]);
        }
        else{
          System.out.println(i + 1+"        "+dayTemp[i]+tempComp[i]);
        }
        i++;
      }
      
    //}    
  }
  public static int monthNum(String monthName){
   int i = 0;
   //String January = new String("January");
    if(monthName.equals("January")){
       i = 31;
       return i;
    }
    if(monthName.equals("February")){
       i = 28;
       return i;
    }
    if(monthName.equals("March")){
       i = 31;
       return i;
    } 
    if(monthName.equals("April")){
       i = 30;
       return i;
    }
    if(monthName.equals("May")){
       i = 31;
       return i;
    }  
    if(monthName.equals("June")){
       i = 30;
       return i;
    }
    if(monthName.equals("July")){
       i = 31;
       return i;
    } 
    if(monthName.equals("August")){
       i = 31;
       return i;
    } 
    if(monthName.equals("September")){
       i = 30;
       return i;
    }
    if(monthName.equals("October")){
       i = 31;
       return i;
    }
    if(monthName.equals("November")){
       i = 30;
       return i;
    }
    if(monthName.equals("December")){
       i = 31;
       return i;
    }
    else{
      return 2;
    }
  }
}

