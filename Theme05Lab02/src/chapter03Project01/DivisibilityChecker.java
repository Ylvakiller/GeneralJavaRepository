package chapter03Project01;

import java.util.Scanner;

/*
 * A number x is divisible by y if the remainder after the division is zero. Write a Java program that 
 * tests whether one number is divisible by another number. Read both the numbers from the 
 * keyboard. 
 */

/*
 * Remarks:
 * No further comments
 */
public class DivisibilityChecker {

	public static void main(String[] args) {
		Scanner keyboard =  new Scanner(System.in);
		System.out.println("Please enter your first number");					//retrieving the 2 numbers
		int num1 = keyboard.nextInt();
		int num1Backup = num1;
		System.out.println("Please enter your second number");
		int num2 = keyboard.nextInt();
		while (num1>num2){														//subtracting the second number from the first
			num1 = num1-num2;
		}
		/*
		 * Checking if the number was divisible, with the above algorithm the variables num1 and num2 should equal if num1 is divisible by num2.
		 * If num1 is not divisible by num2 then num1 will be lower than num2 due to the algorithm above
		 */
		
		if (num1==num2){
			System.out.println("The number " + num1Backup + " is divisible by the number " + num2);
		}else{
			System.out.println("The number " + num1Backup + " is not divisible by the number " + num2);
		}
		keyboard.close();
		System.exit(0);
		

	}

}
