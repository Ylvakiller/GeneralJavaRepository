package chapter05Project2;
/*
 * Program Definition as found on Blackboard:
 * 
 * Define a class called Counter. An object of this class is used to count things, so it records a 
 * count that is a nonnegative whole number. Include methods to set the counter to 0, to 
 * increase the count by 1, increase the count by 10, to decrease the count by 1 and to 
 * decrease the count by 10. Be sure that no method allows the value of the counter to 
 * become negative. Also include an accessor method that returns the current count value, 
 * as well as a method that displays the count on the screen. Do not define an input 
 * method. The only method that can set the counter is the one that sets it to zero. Write a 
 * program to test your class definition (Hint: You need only one instance variable.) 
 */

/*
 * Remarks as found on blackboard:
 * You are creating your own class with the following methods:
 * setToZero()
 * increaseByOne()
 * decreaseByOne()	//should only work if the current value is > 0!
 * increaseByTen()
 * decreaseByTen()
 * getCurrentValue()
 * Only one instant variable is needed: currentValue.
 * The only method that can set a value is the setToZero() method. 
 */

/**
 * 
 * @author Ylva
 * This is a simple class that has an int in it.
 * This class is able to increase or decrease this int, it can also set it to 0.
 * The int is allowed to be negative, not be decreasing below 0 or by overflowing
 */
public class Counter {
	/**
	 * The int around which this whole class is build
	 */
	public int currentValue;

	/**
	 * Constructs the class with a value of 0
	 */
	public Counter(){
		currentValue = 0;
	}
	/**
	 * 
	 * @return the current value of the int on which this class was made
	 */
	public int getCurrentValue(){
		return currentValue;
	}

	/**
	 * Prints the counter value
	 */
	public void printValue(){
		System.out.println("The current counter value is " + currentValue);
	}

	/**
	 * Sets the currentValue to 0
	 */
	public void setToZero(){
		currentValue = 0;
	}


	/**
	 * Increases the currentValue by 1
	 * @return A boolean that becomes false if increasing would overflow the int
	 */
	public boolean increaseByOne(){
		if (currentValue>=(Integer.MAX_VALUE-1)){
			return false;
		}else{
			currentValue++;
			return true;
		}
	}

	/**
	 * Increases the currentValue by 10
	 * @return A boolean that becomes false if increasing would overflow the int
	 */
	public boolean increaseByTen(){
		if (currentValue>=(Integer.MAX_VALUE-10)){
			return false;
		}else{
			currentValue = currentValue+10;
			return true;
		}
	}

	/**
	 * Increases the currentValue by 1
	 * @return A boolean that becomes false if decreasing would let the int be negative
	 */
	public boolean decreaseByOne(){
		if (currentValue==0){
			return false;
		}else{
			currentValue--;;
			return true;
		}
	}

	/**
	 * Increases the currentValue by 1
	 * @return A boolean that becomes false if decreasing would let the int be negative
	 */
	public boolean decreaseByTen(){
		if (currentValue<10){
			return false;
		}else{
			currentValue = currentValue-10;
			return true;
		}
	}
}
