package com.test.ww;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuffer inputstring = new StringBuffer();//to read and save the string from the console
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String");//requesting user to enter the string to reverse
        inputstring.append(input.nextLine());//saving the string from console to the stringbuffer
        //input = new StringBuffer("hope you are doing well");
        String a = inputstring.toString();
        reverseEverything(a); 
        //input.reverse();

    }

    private static String reverseEverything(String s) {//Method that actually does the string reversal
        char[] temp = s.toCharArray();
        int left, right = 0;
        right = temp.length-1;
        for(left=0; left<right;left++,right--)
        {
            //swap values
            char tempo = temp[left];
            temp[left] = temp [right];
            temp[right] = tempo;
        }
         for(char c: temp) {
             System.out.print(c);
         }
        return null;
    }

}
