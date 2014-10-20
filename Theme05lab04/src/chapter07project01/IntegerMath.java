package chapter07project01;

import java.util.Scanner;

/*
 * Program Definition as found on Blackboard:
 * 
 * Write a program that reads integers, one per line, and displays their sum. Here the sum is 
 * calculated after each integer is multiplied by its order in the row, i.e. first integer is multiplied 
 * with 1, second integer with 2, third integer with 3, etc. 
 * Also, display all the numbers read, their value after multiplying it with their order in the row 
 * and an annotation giving its percentage contribution to the sum. 
 * Use a method that takes the entire array as one argument and returns the requested sum of the 
 * number s in the array (Hint:Ask the user for the number of integers to be entered, create an 
 * array of that length, and then fill the array with the integers read. A possible dialogue between 
 * the program and the user follows: 
 * How many numbers will you enter? 
 * 4 
 * Enter 4 integers, one per line: 
 * 2 
 * 1 
 * 1 
 * 2 
 * The sum is: 15. 
 * The numbers are: 
 * 2 ; multiplied with order in row: 2 , which is 13.3333% of the sum. 
 * 1 ; multiplied with order in row: 2 , which is 13.3333% of the sum. 
 * 1 ; multiplied with order in row: 3 , which is 20.0% of the sum. 
 * 2 ; multiplied with order in row: 8 , which is 53.3333% of the sum. 
 */

/*
 * Remarks  as found on blackboard:
 * This is similar to Listing 7.1 p. 479-480.
 */
public class IntegerMath {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many numbers wil you enter?");
		int amount = keyboard.nextInt();
		int[] initialArray = new int[amount];
		System.out.println("Enter the " + amount + " intergers, one per line please:");
		int i = 0;
		while (i<amount){
			initialArray[i] = keyboard.nextInt();
			i++;
		}
		int[] multipliedArray = new int[amount];
		i=0;
		int sum = 0;
		while (i<amount){
			multipliedArray[i] = initialArray[i]*(i+1);
			sum = sum + multipliedArray[i];
			i++;
		}
		
		System.out.println("The sum is " + sum + ".");
		System.out.println("The numbers are:");
		i=0;
		
		while (i<amount){
			System.out.println(initialArray[i] + " ; multiplied with order in the row this is: " + multipliedArray[i] + " , which is " + percentageCalc(sum, multipliedArray[i]) + "% of the sum.");
			i++;
		}
		keyboard.close();
		System.exit(0);
	}
	
	/**
	 * calculates the percentage in max 4 decimal places
	 * @param total The 100%
	 * @param part	The amount of which the percentage needs to be calculated
	 * @return	A double that is the correct percentage in max 4 decimal places
	 */
	private static double percentageCalc(int total, int part){
		double percentage =((double)part/total)*100;
		percentage = percentage*10000;
		percentage = Math.round(percentage);
		percentage = percentage/10000;
		return percentage;
	
	}

}
