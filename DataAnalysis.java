/****************************************************************************
 * Project number: 5
 *
 * Programmer:Chris Hutchison
 *
 * Due Date:3/18/2017
 *
 * CMSC 255 Spring 2017
 *
 * Pledge: I have neither given nor received unauthorized aid on the program.
 *
 * Description: Program opens a user defined file to read in a string being a month name
 * count in that many days and scan in the temperatures in the file and print them with 
 * '+' and '-' next to them if consecutively above or below the average for the month.
 * 
 * Inputs: File Name (fileName)
 *
 * Output: Days in that month and the average temperatures of each day. If three or more
 * days in a row above or below the averagerecorded it will print a '+' or '-' respectively.
 *
 ***************************************************************************/
import java.util.Scanner;
import java.io.*;
public class DataAnalysis
{
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    Scanner inputFile = null;
    int i = 0;
    int k = 1;
    int m = 3;
    int sum = 0;
    int nums = 0;
    double avg = 0.0;
    String monthName = null;
    /*
     * Programmer's Credentials
     */
    printHeader();
    
    boolean isFile = false;
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
         /*
          * Scanning of Month Name and calling of monthNum
          */ 
         monthName = inputFile.next();
         nums = monthNum(monthName);
         int dayTemp[] = new int[nums];
         char tempComp[] = new char[nums];
         /*
          * Scanning numbers into array
          */ 
         i = 0;
         int count = 0;
           while(i < nums){
             if(!(inputFile.hasNext())){
               System.out.println("The number of data points is less than expected: "+i+" given vs. "+nums+" expected for "+monthName);
               count = i;
               break;
             }
           dayTemp[i] = inputFile.nextInt();
           sum = sum + dayTemp[i];
           i++;
         }
         /*
          * Calculating the average
          */ 
         avg = sum / nums;
         /*
          * While loop to add in the '+' and the '-'
          */ 
         i = 0;
         while(i < nums){
           if((i + 2) < dayTemp.length){
           if(dayTemp[i] > avg){
             if(dayTemp[i + 1] > avg){
               if(dayTemp[i + 2] > avg){
                  tempComp[i] = '+';
                  tempComp[i + 1] = '+';
                  tempComp[i + 2] = '+';
                 m = 3;
                 k = 1;
                 while(k != 0){
                   if(dayTemp[i + m] > avg){
                     tempComp[i + m] = '+';
                     m++;
                   }
                   else{
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
                 while(k != 0){
                   if(dayTemp[i + m] < avg){
                     tempComp[i + m] = '-';
                     m++;
                   }
                   else{
                     k = 0;
                   }
                   }
                 }
               }
             }
           }
           else{
             break;
           }
           i++;  
           }
    i = 0;  
    /*
     * Loops to print output 
     */ 
    System.out.printf("The average temperature for %s was %.2f%n", monthName, avg);
    if(count != nums){
      while(i < count){
        if(i > 8){
          System.out.println(i + 1+"       "+dayTemp[i]+tempComp[i]);
        }
        else{
          System.out.println(i + 1+"        "+dayTemp[i]+tempComp[i]);
        }
        i++;
      }
    }
    if(i == 0){
      while(i < nums){
        if(i > 8){
          System.out.println(i + 1+"       "+dayTemp[i]+tempComp[i]);
        }
        else{
          System.out.println(i + 1+"        "+dayTemp[i]+tempComp[i]);
        }
        i++;
      }    
   }
    scan.close();
  }
  /*
   * Method to check string for Month Name and return days in that month 
   */ 
  public static int monthNum(String monthName){
   int i = 0;
    if(monthName.equals("January")){
       i = 31;
       return i;
    }
    else if(monthName.equals("February")){
       i = 28;
       return i;
    }
    else if(monthName.equals("March")){
       i = 31;
       return i;
    } 
    else if(monthName.equals("April")){
       i = 30;
       return i;
    }
    else if(monthName.equals("May")){
       i = 31;
       return i;
    }  
    else if(monthName.equals("June")){
       i = 30;
       return i;
    }
    else if(monthName.equals("July")){
       i = 31;
       return i;
    } 
    else if(monthName.equals("August")){
       i = 31;
       return i;
    } 
    else if(monthName.equals("September")){
       i = 30;
       return i;
    }
    else if(monthName.equals("October")){
       i = 31;
       return i;
    }
    else if(monthName.equals("November")){
       i = 30;
       return i;
    }
    else if(monthName.equals("December")){
       i = 31;
       return i;
    }
    else{
       i = 0;
       return i;
    }
  }
  /*
   * Method used to print programmer's credentials
   */ 
      public static void printHeader(){
      System.out.println("Chris Hutchison");
      System.out.println("CMSC 255 Spring 2017");
      System.out.println("Project Number 4\n");
    }
}