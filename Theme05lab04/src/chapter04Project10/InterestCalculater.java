package chapter04Project10;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*
 * Program Definition as found on Blackboard:
 * 
 * Write a program that reads a bank account balance and an interest rate and displays the value 
 * of the account in ten years. The output should show the value of the account for three different 
 * methods of compounding interest: annually, monthly, and daily. When compounded annually, 
 * the interest is added once per year at the end of the year. When compounded monthly, the 
 * interest is added 12 times per year. When computed daily, the interest is added 365 times per 
 * year. You do not have to worry about leap years; assume that all years have 365 days. For 
 * annual interest, you can assume that the interest is posted exactly one year from the date of 
 * deposit. In other words, you do not have to worry about interest being posted on a specific day 
 * of the year, such as December 31. Similarly, you can assume that the interest is posted exactly 
 * one month after it is deposited. Since the account earns interest on the interest, it should have a 
 * higher balance when interest is posted more frequently. Be sure to adjust the interest rate for 
 * the time period of the interest. If the rate is 5 percent, you use 5/12 percent when posting 
 * monthly interest and 5/365 percent when posting daily interest. Perform this calculation using a 
 * loop that adds in the interest for each time period, that is, do not use some sort of algebraic 
 * formula. Your program should have an outer loop that allows the user to repeat this calculation 
 * for a new balance and interest rate. The calculation is repeated until the user asks to end the 
 * program. 
 */


/*
 * Remarks as found on blackboard:
 * Do not use a algebraic formula to calculate the final amount but use a for loop that adds in the interest for each time period.
 * The loop that has to be done is a for loop with an integer n that increases every time.
 * This integer n needs to be increases the following number of times:
 * amount_of_years x number_of_times_compounding.
 */
public class InterestCalculater {

	
	
	/*
	 * Okay let me tell you a story about how this program came to be;
	 * I started with just the simple assignment, using doubles to calculate the balance for a specified interest over a 10 year period
	 * However I figured if I would just use a formula like double = double*(1+(interest/100)) I would get quite accurately, but not really precise.
	 * Also if I where to round this of using double = Math.round(double*100)/100 I might get an overflow for very high values.
	 * I started looking around for other data formats in java and ran into the BigDecimal format.
	 * This is more an exercise for me to learn about the BigDecimal data format than it is anything else.
	 * I mean, just using double would result in a pretty good estimate for the scope of this assignment.
	 * However I wanted better than that.
	 * the current program calculates the balance up till 100 digits behind the decimal point.
	 * I would say that is pretty accurate...
	 * if the program freezes after it has told you the balance after a year, or if it freezes after it has told you the balance for a month,
	 * then the problem is runtime, and it is basically eating up the CPU time.
	 * You can lower the precision by changing the next variable
	 */
	public static int precision = 100;
	
	/*
	 * Now I will explain some of the program structure in general.
	 * The calculateBalance method needs a balance and an interest and the amount of times it needs to work.
	 * This is the reason for the year, month and day calculators.
	 * These 3 methods calculate the correct interest and amount of times that calculateBalance will need
	 * For the rest look into the comments in the code for more detailed explanation on every part, I tried to make it as detailed as needed
	 */
	
	
	
	public static void main(String[] args) {
		int interestRate = 5;
		
		Scanner keyboard = new Scanner(System.in);
		
		//Starting a loop that keeps on going until the user says otherwise
		boolean keepRunning = true;
		while(keepRunning){
			//These first lines are just to get the balance and the interest needed for the calculations and then warns the user that it is going to calculate
			System.out.println("Please enter your bank balance");
			BigDecimal initialBalance = keyboard.nextBigDecimal();
			System.out.println("Now enter your interest rate for a year, this program will use that for both month and daily interest calculations");
			BigDecimal interest = keyboard.nextBigDecimal();
			System.out.println("Calculating.");
			
			long timestamp = System.currentTimeMillis();
			
			BigDecimal yearBalance = yearCalculator(initialBalance, interest, 10);						//Calculate the balance using anual interest
			yearBalance = yearBalance.setScale(2, RoundingMode.HALF_UP);								//Rounding the balance to show only 2 digits since normally when displaying a financial number it only goes as far as 2 digits behind the decimal point (cents)
			System.out.println("The following balances where calculated after a 10 year period");		//Start with writing output to the user
			System.out.println("Anual interest gives: " + yearBalance.toPlainString());
			BigDecimal monthBalance = monthCalculator(initialBalance, interest, 10);
			monthBalance = monthBalance.setScale(2, RoundingMode.HALF_UP);
			System.out.println("Monthly interest gives: " + monthBalance.toPlainString());
			BigDecimal dayBalance = dayCalculator(initialBalance, interest, 10);
			dayBalance = dayBalance.setScale(2, RoundingMode.HALF_UP);
			System.out.println("Daily interest gives: " + dayBalance.toPlainString());
			System.out.println();
			System.out.println("This calculation took " + ((double)(System.currentTimeMillis()-timestamp)/1000) + " seconds to complete");
			
			// next part is used to exit the loop
			System.out.println("If you want to stop the program, enter an n and enter, otherwise enter any other character to continue");
			String temp = keyboard.next();
			if (temp.equalsIgnoreCase("n")){
				keepRunning = false;
			}
		}
		keyboard.close();
		System.exit(0);

	}
	
	
	/**
	 * Adds the interest on the intial balance for a specified amount of times
	 * 
	 */
	static BigDecimal calculateBalance(BigDecimal initial, BigDecimal interest, int times){
		int i = 0;
		interest = interest.divide(BigDecimal.valueOf(100));
		interest = interest.add(BigDecimal.valueOf(1));
		while(i<times){
			
			initial = initial.multiply(interest);
			i++;
		}
		return initial;
		
	}
	
	/**
	 * Uses the calculate balance method to calculate the balance after 'years' amount of years with interest adding at the end of the year
	 * Since I do not have to divide the interest for this case I can just use interest, and the same goes for years
	 */
	static BigDecimal yearCalculator(BigDecimal balance, BigDecimal interest, int years){
		balance = calculateBalance(balance, interest, years);
		return balance;
	}

	/**
	 * Uses the calculate balance method to calculate the balance after 'years' amount of years with interest adding at the end of each month
	 * Divides the interest to 12 steps and makes the program run 12 times as long, in that way calculating the balance for monthly interest
	 * The part where the interest per month is calculated only calculates the interest till 100 digits after the decimal point, that should be more than enough
	 */
	static BigDecimal monthCalculator(BigDecimal balance, BigDecimal interest, int years){
		interest = 
		balance = calculateBalance(balance, interest.divide(BigDecimal.valueOf(12), precision ,RoundingMode.HALF_UP), (years*12));
		return balance;
	}
	
	/**
	 * Uses the calculate balance method to calculate the balance after 'years' amount of years with interest adding at the end of each day
	 * Divides the interest to 365 steps and makes the program run 365 times as long, in that way calculating the balance for daily interest
	 * The part where the interest per day is calculated only calculates the interest till 100 digits after the decimal point, that should be more than enough
	 */
	static BigDecimal dayCalculator(BigDecimal balance, BigDecimal interest, int years){
		balance = calculateBalance(balance, interest.divide(BigDecimal.valueOf(365), precision ,RoundingMode.HALF_UP), (years*365));
		return balance;
	}
}
