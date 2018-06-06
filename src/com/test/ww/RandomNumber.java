/**
 * 
 */
package com.test.ww;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class RandomNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int c, num;
	    Random t = new Random();
	    
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nth smallest element to print");
		num = scan.nextInt();
	    
	    int[] numbers = new int[500];
	 
	    
	 
	    for (c = 0; c < numbers.length; c++) {
	    	numbers[c] = (t.nextInt(1000));
	    	System.out.println(numbers[c]);
	  }
	    Arrays.sort(numbers);
	    System.out.println("Sorted" +Arrays.toString(numbers));
	    //print the nth smallest number to print
	    System.out.println("nth smallest" +numbers[num]);
}
}
