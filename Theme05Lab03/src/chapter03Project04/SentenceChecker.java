package chapter03Project04;

import java.util.Scanner;

/*
 * Program Description:
 * Write a program that reads a one-line sentence as input and then displays the following 
 * response: If the sentence ends with a question mark (?) and the input contains an even number 
 * of characters, display the word Yes. If the sentence ends with a question mark and the input 
 * contains an odd number of characters, display the word No. If the sentence ends with an 
 * exclamation point (!), display the word Wow. In all other cases, display the words You 
 * always say followed by the input string enclosed in quotes. Your output should all be on one 
 * line. Be sure to note that in the last case, your output must include quotation marks around the 
 * echoed input string. In all other cases, there are no quotes in the output. Your program does not 
 * have to check the input to see that the user has entered a legitimate sentence. 
 */

/*
 * Program remarks:
 * Do not use Arrays.sort or any other method written by another programmer.
 * Try to determine all the possibilities the user can input and give an if-else statement for each possibility:
 */

public class SentenceChecker {
	/*
	 * The assignment was not completely clear on this but I count the ? or ! marks when checking if the input is of odd or even numbered length
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please Type in a sentence and end with an enter");
		String input = keyboard.nextLine();
		
		
		//check if the sentence ends with a question mark or an exclamation mark
		boolean questionMarkEnd = input.endsWith("?");
		boolean exclamationMarkEnd = input.endsWith("!");
		
		//check if the input is of an even or odd size
		int length = input.length();
		boolean even;
		if (length % 2 == 0) {
			  even=true;
		} else {
			  even = false;
		}
		
		//Going through all the possibilities and printing the outputs for each one
		if(questionMarkEnd&&even){
			System.out.println("Yes");
		}else if(questionMarkEnd&&!even){
			System.out.println("No");			
		}else if(exclamationMarkEnd){
			System.out.println("Wow");
		}else{
			System.out.println("You always say \"" + input + "\"");
		}
		
		//ending and cleaning up the program
		keyboard.close();
		System.exit(0);
		

	}

}
