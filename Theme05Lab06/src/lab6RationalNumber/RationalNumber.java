package lab6RationalNumber;

import java.math.BigInteger;

public class RationalNumber {

	/**
	 * The numerator is the number before the / sign
	 */
	private int numerator;

	/**
	 * The denominator is the number after the / sign
	 */
	private int denominator;

	/**
	 * Default constructor, sets the rational number to 0/1
	 */
	public RationalNumber(){
		numerator =0;
		denominator = 1;
	}

	/**
	 * Constructor that takes as input a numerator and denominator
	 * @param numerator The numerator to store
	 * @param denominator The denominator to store, cannot be 0
	 */
	public RationalNumber(int numerator, int denominator){
		this.numerator =numerator;
		this.denominator =denominator;
		simplify();
	}

	/**
	 * Gets the numerator
	 * @return The currently stored numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Sets the numerator and denominator and simplifies them
	 * @param numerator The numerator to store
	 * @param denominator The denominator to store, cannot be 0
	 */
	public void setRatio(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator =denominator;
		simplify();
	}

	/**
	 * Gets the denominator
	 * @return The Currently stored denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Simplifies the stored numerator and denominator
	 */
	private void simplify(){
		int gcd = getGCD(numerator,denominator);
		if(gcd!=0){
			numerator = numerator/gcd;
			denominator = denominator/gcd;
		}
	}

	/**
	 * Calculates the greatest common divisor of the inputs.
	 * Note that the inputs should be non zero integers
	 * @param numerator Used in the calculations as a numerator
	 * @param denominator Used in the calculations as a denominator
	 * @return an int that is the greatest common divisor
	 */
	static private int getGCD(int numerator, int denominator){
		BigInteger tempNumerator =BigInteger.valueOf(numerator);
		BigInteger tempDenominator =BigInteger.valueOf(denominator);
		BigInteger tempGCD = tempNumerator.gcd(tempDenominator);
		return tempGCD.intValue();
	}

	/**
	 * Returns the fraction in a string format
	 * @return The format is numerator/denominator
	 */
	public String toString(){
		String temp = String.valueOf(numerator) + "/" + String.valueOf(denominator);
		return temp;
	}

	/**
	 * Calculates the estimate of the fraction
	 * @return A double approximation of the fraction
	 */
	public double getValue(){
		double tNum = numerator;
		double tDen = numerator;
		return tNum/tDen;	
	}
}
