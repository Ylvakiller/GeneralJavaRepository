package chpater04Project08;

import java.util.Scanner;

/*
 * Program Description:
 * Develop an algorithm for a simple game of guessing at a secret five-digit code. When the user 
 * enters a guess at the code, the program returns two values: the number of digits in the guess 
 * that are in the correct position and the sum of those digits. For example, if the secret code is 
 * 53840, and the user guesses 83241, the digits 3 and 4 are in the correct position. Thus, the 
 * program should respond with 2 and 7. Allow the user to guess a fixed number of times. 
 */

/*
 * Program remarks:
 * Use a while loop to allow the user to enter a new guess for the 5 digit code. For each guess check how many digits are correct and sum these digits, i.e. the digits that are correctly entered.
 * If user has guessed the secret code correctly congratulate the user and exit the program.
 * If maximum number of attempts has been used by the user without guessing the correct code, inform the user about this and then exit the program.
 */
public class NumberGame {

	
	public static void main(String[] args) {
		int tries = 3;													//change this number if you want to alter the amount of attempts a user has, I have put it on 3 for testing although it is unlikely someone will guess the code in 3 attempts
		//generating number
		int rawRandom = (int) (Math.random()*100000);
		
		//Uncomment the next sentence to see the number you need to guess, might be handy for testing
		//System.out.println(rawRandom);
		
		
		int [] secret = digitSeperator(rawRandom);

		Scanner keyboard = new Scanner(System.in);
		System.out.println("You will have " + tries + " tries to crack the code");
		System.out.println("Enter a number and guess");
		boolean correctGuess=false;
		int attempt=0;
		while(!correctGuess&&tries>attempt){
			attempt++;
			int guessInt = keyboard.nextInt();
			int[] guess = digitSeperator(guessInt);							//getting an int array holding all the separate digits from the guess
			int numCorrect = 0;
			int sumCorrect = 0;
			int i = 0;
			while (i<5){													//checking which numbers are the same and in doing so calculating both the sum and the amount of correct numbers
				if (secret[i] == guess[i]){
					numCorrect++;
					sumCorrect = sumCorrect+guess[i];
				}
				i++;
			}
			
			if (numCorrect == 5){											//cause to notify the user if he has correctly guessed the code along with statement to get out of the while loop
				System.out.println("Congratulations!!!!");
				System.out.print("You have succesfully cracked the secret code in " + attempt);
				if(attempt==1){
					System.out.println(" try!");							//making sure the program uses the plural when needed
				}else{
					System.out.println(" tries!");
				}
				correctGuess = true;
			}else{
				System.out.println("You had " + numCorrect + " digits in the right place.");			//printing information the used
				System.out.println("The sum of these digits is " + sumCorrect);
			}
			
			if((tries-attempt)==0){																		//checking if the user still has tries left and giving that information to the used
				System.out.println("You failed to crack the code...");
			}else{
				System.out.println("You have " + (tries-attempt) + " tries left, please enter your next number");
			}
		}
		
		keyboard.close();
		System.exit(0);
		

	}
	
	/*
	 * returns an array with 5 digits in normal order created form an 5 digit number
	 * if the input has less than 5 digits than 0's will be added to the front to make it 5 digits
	 * if the input has more than 5 digits than only the last 5 digits are used
	 */
	public static int[] digitSeperator(int input){
		int[] returnArray = new int[5];
		int i = 4;
		while(i>=0){
			returnArray[i] = input%10;				//getting the last digit from input and storing that in the last position in the array that is not used yet
			input = input/10;						//removing the last digit from input
			i--;
		}
		return returnArray;
		
	}

}
