package chapter02Project09;

import java.util.Scanner;



/*
 * Project definition
 * Project 9: 
 * Write a Java program that asks the user to enter a favorite color, a favorite food, a favorite 
 * animal, and the first name of a friend or relative. The program should then print the following 
 * two lines, with the user’s input replacing the items in italics: 
 * I had a dream that Name ate a Color Animal
 * And said it tasted like Food! 
 * For example, if the user entered blue for the color, hamburger for the food, dog for the animal, 
 * and Jake for the person’s name, the output would be 
 * I had a dream that Jake ate a blue dog 
 * And said it tasted like hamburger! 
 * Don’t forget to put the exclamation mark at the end. 
 */

/*
 * remarks:
 * 2.9; p. 145:
 * No further comments
 */
public class StringGenerator {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please tell me your favourite colour;");					// because this is the correct spelling :)
		String Colour = keyboard.nextLine();
		System.out.println("Now tell me the name of your favourite food;");
		String Food = keyboard.nextLine();
		System.out.println("And what is your favourite animal?");
		String Animal = keyboard.nextLine();
		System.out.println("Finally I would ask you to enter the name of a friend or relative;");
		String Friend = keyboard.nextLine();
		System.out.println("Generating output, please hold on...");
		System.out.println();
		System.out.println("I had a dream that " + Friend + " ate a " + Colour + " " + Animal);
		System.out.println("And said it tasted like " + Food + "!");
		System.out.println();
		System.out.println("Output succesfully generated, terminating program");
		keyboard.close();
		System.exit(0);
		

	}

}
