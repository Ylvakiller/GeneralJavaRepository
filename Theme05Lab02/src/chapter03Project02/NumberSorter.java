package chapter03Project02;

import java.util.Scanner;

/*
 * Write a Java program to read in three nonnegative numbers from the keyboard. Display the 
integers in increasing order. 
 */

/*
 * Remarks:
 * Try to determine what all the possibilities are.
 * For each possibility write a if statement. All if-else statement should be nested.
 * A user can do 1 out of 10 possibilities:
 * 1 2 3	numbers already in increasing order
 * 1 3 2	other orders of the values of the numbers
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 * 1 1 2	two numbers have the same value
 * 1 2 1
 * 2 1 1
 * 1 1 1	all numbers have the same value
 * Again this project is about using if-else statements in all possible forms, so stick to the previous mentioned tasks!
 */
public class NumberSorter {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please give me 3 numbers seperated by an enter");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		int num3 = keyboard.nextInt();
		int temp = 0;
		
		//The first level of if statements determine what the highest number is,
		//The second level then determines what the second number is and then the sorting happens.
		if (num3>num2&&num3>num1){
			if(num2>num1){
				System.out.println("Numbers already in correct order");
			}else{
				temp = num1;
				num1 = num2;
				num2 = temp;
			}
		}else if(num2>num1&&num2>num3){
			if(num1>num3){
				temp  = num3;
				num3 = num2;
				num2 = num1;
				num1 = temp;
				
			}else{
				temp  = num3;
				num3 = num2;
				num2 = temp;
			}
		}else if(num1>num2&&num1>num3){
			if(num2>num3){
				temp = num3;
				num3 = num1;
				num1 = temp;
			}else{
				temp = num3;
				num3 = num1;
				num1 = num2;
				num2 = temp;
			}
		}else{
			//If the program ever gets here then something going horrible wrong... should not be able to happen, if you can get to hear please tell me how you got here.
			System.err.println("Unkown programming error, terminating program error code 1");
			keyboard.close();
			System.exit(1);
		}
		System.out.println("The correct order is " + num1 + " " + num2 +  " " + num3);
		//I hope that this is what is meant by nesting if statements, it works quite perfectely using this algorithm though...
	}

}
