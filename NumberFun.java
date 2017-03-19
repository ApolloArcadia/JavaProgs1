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
public class NumberFun
{
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    Scanner inputFile = null;
    /*
     * Programmer's Credentials
     */
    printHeader();
    
    boolean isFile = false;
    int j = 1;
    while(j == 1){
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
         int even = 0;
         int palindrome = 0;
         int prime = 0;
         int emirp = 0;
    /*
     * Loop to read in integers and check for commas
     */
         while(inputFile.hasNext()){
           int num = inputFile.nextInt();
              if(num < 0){
                System.out.print(num+" is not a valid input");
                System.out.printf("%n%n");
                break;
              }
           System.out.print(num+" ");
              if(isEven(num)){
                even = 1;
              }
              if(isPrime(num)){
                prime = 1;
              }
              if(isPalindrome(num)){
                palindrome = 1;
              }
              if(isEmirp(num)){
                emirp = 1;
              }
              if(isEven(num)){
                if(prime == 1 || palindrome == 1 || emirp == 1){
                  System.out.print("- even,");
                }
                else{
                  System.out.print("- even");
                }  
              }
              if(isPrime(num)){
                if(even == 0 && palindrome == 0 && emirp == 0){
                  System.out.print("- prime");
                }
                if(even == 1 && palindrome == 0 && emirp == 0){
                  System.out.print(", prime");
                }
                if(even == 0 && (palindrome == 1 || emirp == 1)){
                  System.out.print("- prime,");
                }
                if(even == 1 && (palindrome == 1 || emirp == 1)){
                  System.out.print(" prime,");
                }
              }
              if(isPalindrome(num)){
                if(even == 0 && prime == 0 && emirp == 0){
                  System.out.print("- palindrome");
                }
                if((even == 1 || prime == 1) && emirp == 0){
                  System.out.print(" palindrome");
                }
                if((even == 1 || prime == 1) && emirp == 1){
                  System.out.print(" palindrome,");
                }
              }
              if(isEmirp(num)){
                if(even == 0 && prime == 0 && palindrome == 0){
                  System.out.print("- emirp");
                }
                if(even == 1 || prime == 1 || palindrome == 1){
                  System.out.print(" emirp");
                }
              }
              System.out.printf("%n");
              even = 0;
              prime = 0;
              palindrome = 0;
              emirp = 0;
              isFile = false;
    }
  }
     /*
     * Closing the two scanners used 
     */ 
     scan.close();
     inputFile.close();
  
 }   
    /*
     * Statement to check if integer is even
     */ 
    public static boolean isEven(int num){
      return num%2==0;
    }
    /*
     * Statement to check if integer is even
     */ 
    public static boolean isPrime(int num){
      int i;
      if(num < 2){
        return false;
      }
     
      for(i = 2; i < num; i++){
        if(num % i == 0){
          return false;
        }
      }
      return true;
    }
    /*
     * Statements to reverse number and check for palindrome
     */ 
    public static boolean isPalindrome(int num){
      return num == reverse(num);
    }
    public static int reverse(int num){
      int revResult = 0;
      
      while(num != 0){
        int endNum = num % 10;
        revResult = revResult * 10 + endNum;
        num = num / 10;
      }
      return revResult;
    }
    /*
     * Statment to check integer for being emirp(backwards prime)
     */ 
    public static boolean isEmirp(int num){
      if(isPrime(num) && isPrime(reverse(num))){
        return true;
      }
      else{
        return false;
      }
    }
    /*
     * Statement to print programmer credentials
     */ 
    public static void printHeader(){
      System.out.println("Chris Hutchison");
      System.out.println("CMSC 255 Spring 2017");
      System.out.println("Project Number 4\n");
    }
    
 
}