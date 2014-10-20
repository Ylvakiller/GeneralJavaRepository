package chapter03Project09;

import java.util.Scanner;

/*
 * Program Description:
 * Write a program that reads a string from the keyboard and tests whether it contains a valid 
 * date. Display the date and a message that indicates whether it is valid. If it is not valid, also 
 * display a message explaining why it is not valid. 
 * The input date will have the format yyyy/dd/mm. A valid month value mm must be from 
 * 1 to 12 (January is 1). The day value dd must be from 1 to a value that is appropriate for the 
 * given month. September, April, June, and November each have 30 days. February has 28 days 
 * except for leap years when it has 29. The remaining months all have 31 days each. A leap year is 
 * any year that is divisible by 4 but not divisible by 100 unless it is also divisible by 400. 
 */

/*
 * Program Remarks:
 * Read the date as a string from the keyboard. 
 * Use the substring() method of the class String as explained on p. 106 to convert the string into substrings and then convert the substrings into Integers as explained in figure 2.8 p. 138.
 * Then use a switch statement for the month possibilities and determine whether the days and years are correct.
 */

public class LeapYearCalculater {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please give me a date in the format yyyy/dd/mm and I will check if it is correct");
		String rawInput = keyboard.next();
		//Checking if the input is not to short to avoid OutOfBounds errors when taking the substrings.
		if(rawInput.length()<10){
			System.err.println("The Input you gave is to short...");
			System.err.println("Terminating program. Error Code 1");
			keyboard.close();
			System.exit(1);
		}
		String suby, subm, subd;
		suby = rawInput.substring(0, 4);			//seperating the year, day and month from the input
		subd = rawInput.substring(5, 7);
		subm = rawInput.substring(8, 10);
		int year = Integer.parseInt(suby);			//transforming the inputs into type int
		int month = Integer.parseInt(subm);
		int day = Integer.parseInt(subd);

		boolean correctDate = false;
		//Checking if the date is correct
		switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        	if(day <= 31){correctDate=true;}
            break;
        case 4: case 6: case 9: case 11:
        	if(day <= 30){correctDate=true;}
            break;
        case 2:
            if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))	//checking if its a leap year or not
            	if(day <= 29){correctDate=true;}
            else
            	if(day <= 28){correctDate=true;}
            break;
        default:
        	correctDate=false;
            break;
		}
		
		//Printing output
		if(correctDate){
			System.out.println("The input " + rawInput + " is a correct date.");
		}else{
			System.out.println("The input " + rawInput + " is not a correct date.");
		}
		
		//Cleaning up the resources and ending the program
		keyboard.close();
		System.exit(0);
		

	}

}
