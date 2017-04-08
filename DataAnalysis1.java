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
public class DataAnalysis1
{
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    Scanner inputFile = null;
    int i = 0;
    int sum = 0;
    double avg = 0;
    /*
     * Programmer's Credentials
     */
    printHeader();
    
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
         int dayTemp[] = new int[nums];
         char tempComp[] = new char[nums];
         i = 0;
         int count = 0;
         while(inputFile.hasNextInt()){
           dayTemp[i] = inputFile.nextInt();
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

            // if(m == 3){
 
            // }
           else{
             break;
           }
           i++;  
           }
      i = 0;  
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
      return 2;
    }
  }
      public static void printHeader(){
      System.out.println("Chris Hutchison");
      System.out.println("CMSC 255 Spring 2017");
      System.out.println("Project Number 4\n");
    }
}