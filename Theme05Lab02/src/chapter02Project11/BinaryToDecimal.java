package chapter02Project11;

import java.util.Scanner;

/*
 * Write a Java program that reads a four-bit binary number from the keyboard as a string and 
 * then converts it into decimal. For example, if the input is 1100, the output should be 12. Hint: 
 * Break the string into substrings and then convert each substring to a value for a single bit. If the 
 * bits are b0 , b1 , b2 and b3 the decimal equivalent is 8b0 + 4b1 + 2b2 + b3 . 
 */

/*
 * Remarks:
 * First read a string from the keyboard
 * Then convert the string into small substrings
 * Then convert the substrings into integers
 * Do some calculation with the integers
 * This project is mostly about messing about with strings and not about the actual conversion: stick to the previous mentioned tasks!
 */

public class BinaryToDecimal {

	/*
	 * This program can convert a 4 digit number, it however can also convert a 1 digit number, or a 31 digit number, or any number in between...
	 */
	public static void main(String[] args) {
		Scanner keyboard =  new Scanner(System.in);
		System.out.println("Please enter a binary number;");
		String input = keyboard.nextLine();
		int length = input.length();
		String[] stringArray = new String[length];
		int i = 0;
		
		//taking the string apart and putting it in a string array with least significant bit first
		while (length>0){
			String temp = input.substring(length-1, length);
			stringArray[i] = temp;
			i++;
			length--;
		}
		
		//Checking if the sequence consists of only binary digits (either 0 or 1)
		while (i>0){				
			if (stringArray[i-1].contains("0")||stringArray[i-1].contains("1")){
				
			}else{
				System.err.println("Error, input contains non binary digits!, terminating program error code 1");
				keyboard.close();
				System.exit(1);
			}
			i--;
		}
		if(stringArray.length>31){
			System.err.println("The number you entered is to large for this program to proces.");
			System.out.println("This program is designed for number that have less than 32 bits.");
			System.out.println("Terminating program, error code 2");
			keyboard.close();
			System.exit(2);
		}
		//Converting the string binary array towards a decimal number, this by converting the substring at a certain position towards an int, then multiplying that with the correct decimal value for that bit and adding that towards the total.
		int decimal = 0;
		length = stringArray.length;
		i=0;
		while(length>i){
			decimal = decimal+(int)(Math.pow(2,i)*Integer.parseInt(stringArray[i]));
			i++;
		}
		System.out.println("The binay number " + input + " equals " + decimal + " in decimal.");
		
		keyboard.close();
		System.exit(0);

	}

}
