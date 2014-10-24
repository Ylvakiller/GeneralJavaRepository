package lab6Elections;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Holds the names for the candidates for both president and vice-president
 * Records the total amount of votes
 * Allows the names for candidates to be changed, but only when the number of votes is 0 for all candidates
 * Allows the votes to be reset. 
 * Can return the standings for the election
 * 
 * The total amount of votes are stored in BigInteger types to allow more then 9,223,372,036,854,775,807 votes. (maximum size of a long data type)
 * Okay there are only around 7,000,000,000 people on the planet so each person would have to vote at least 1.3 billion times for it to reach the maximum value of long.
 * However I feel that it is better to be safe then sorry, imagine if I would have used an int data type...
 * Then there would be only 2 billion votes possible for one candidate, even with our current global population that would mean that around 1/3 people could vote.
 * Imagine a system like this needing to be used in the far future when the population of humans spans between planets...
 * 
 * As I said, you do not need to use BigIntegers however it is better to be save then sorry,
 * Especially since BigIntegers are basically int[] that are calculated into 1 big number so it allocates enough memory but only as much as it needs.
 * For all values of votes below Int.Maxvalue() it will only allocate the amount of bytes an int data type has,
 * So in that range it is more memory efficient then a long data type.
 * 
 * Records the vote for a specific voter
 * @author Ylva
 */
public class VoteRecorder {
	/**
	 * Name of the first candidate for president.
	 */
	private static String nameCandidatePresident1 = "";
	/**
	 * Name of the second candidate for President.
	 */
	private static String nameCandidatePresident2;
	/**
	 * Name of the first Vice President candidate.
	 */
	private static String nameCandidateVicePresident1;
	/**
	 * Name of the second Vice President Candidate.
	 */
	private static String nameCandidateVicePresident2;

	/**
	 * Total amount of votes that have been cast for the first candidate for president.
	 */
	private static BigInteger votesCandidatePresident1 = BigInteger.ZERO;

	/**
	 * Total amount of votes that have been cast for the second candidate for president.
	 */
	private static BigInteger votesCandidatePresident2 = BigInteger.ZERO;

	/**
	 * Total amount of votes that have been cast for the first candidate for vice president.
	 */
	private static BigInteger votesCandidateVicePresident1 = BigInteger.ZERO;

	/**
	 * Total amount of votes that have been cast for the second candidate for vice president.
	 */
	private static BigInteger votesCandidateVicePresident2 = BigInteger.ZERO;

	/**
	 * Holds the amount of total voters, this is used to calculate the next voteID in case a voter does not vote for a president of vice president
	 */
	private static BigInteger voters = BigInteger.ZERO;
	
	/**
	 * Used to get user input from the keyboard
	 */
	private static Scanner keyboard;

	/**
	 * This is the vote that this specific person has cast for president
	 * If 0 this means no vote is cast, if 1 or 2 it means that candidate for president
	 */
	private int myVoteForPresident;

	/**
	 * This is the vote that this specific person has cast for vice president
	 * If 0 this means no vote is cast, if 1 or 2 it means that candidate for vice president
	 */
	private int myVoteForVicePresident;

	/**
	 * The voteID, can be used to figure out what voter this is, defaults to voters +1
	 */
	private BigInteger voteID;

	/**
	 * placeholder, will be deleted later
	 */
	private boolean confirmed;

	
	/**
	 * Default constructor, sets voteID and increments the amount of voters
	 */
	public VoteRecorder(){
		voteID = voters.add(BigInteger.ONE);
		voters=voters.add(BigInteger.ONE);

	}

	/**
	 * This constructor is used in the testing of this whole program, it records votes without any user interaction
	 * @param president the vote needed to be recorded for president
	 * @param vicePresident	The vote needed to be recorder for vice president
	 */
	public VoteRecorder(int president,int vicePresident){
		voteID = voters.add(BigInteger.ONE);
		voters=voters.add(BigInteger.ONE);
		recordVotes(president, vicePresident);
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * This constructor does not count, it is a constructor used to only set names of the presidents
	 * The constructor sets the votes back to 0 for all of this type
	 * @param president1 name of the first candidate for president
	 * @param president2 name of the second candidate for president
	 * @param vicePresident1 name of the first candidate for vice president
	 * @param VicePresident2 name of the second candidate for vice president
	 */
	public VoteRecorder(String president1, String president2, String vicePresident1, String VicePresident2){
		resetVotes();
		setCandidatesPresident(president1, president2);
		setCandidatesVicePresident(vicePresident1, VicePresident2);
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Getter method for the name of the first presidential candidate
	 * @return a string with the name of the first presidential candidate
	 */
	public static String getNameCandidatePresident1() {
		return nameCandidatePresident1;
	}
	/**
	 * Getter method for the name of the second presidential candidate
	 * @return a string with the name of the second presidential candidate
	 */

	public static String getNameCandidatePresident2() {
		return nameCandidatePresident2;
	}
	/**
	 * Getter method to retrieve the name of the first candidate for vice president
	 * @return a string the name of the second candidate for vice president
	 */

	public static String getNameCandidateVicePresident1() {
		return nameCandidateVicePresident1;
	}
	/**
	 * Getter method to retrieve the name of the second candidate for vice president
	 * @return a string the name of the second candidate for vice president
	 */

	public static String getNameCandidateVicePresident2() {
		return nameCandidateVicePresident2;
	}
	

	/**
	 * Only works if the amount of votes for the president is equal to 0
	 * This in order to prevent fraud during the election
	 * @param candidate1 Name that you want to set the first candidate of president to
	 * @param candidate2 Name that you want to set the second candidate of president to
	 * @return true if successful, false if the amount of votes was not equal to 0
	 */
	public static boolean setCandidatesPresident(String candidate1, String candidate2){
		if(votesCandidatePresident1.equals(BigInteger.ZERO)&&votesCandidatePresident2.equals(BigInteger.ZERO)){
			
			nameCandidatePresident1=candidate1;
			nameCandidatePresident2=candidate2;
			return true;
		}else{
			return false;
		}

	}

	/**
	 * Only works if the amount of votes for the president is equal to 0
	 * This in order to prevent fraud during the election
	 * @param index 1 or 2 depending on which candidate for president to change
	 * @param name the name to change the name of the candidate towards
	 * @return true if successful, false if the amount of votes was not equal to 0 or the index was of a wrong format
	 */
	public static boolean setCandidatesPresident(int index, String name){
		if(votesCandidatePresident1.equals(BigInteger.ZERO)&&votesCandidatePresident2.equals(BigInteger.ZERO)){
			if(index==1){
				nameCandidatePresident1=name;
			}else if (index==2){
				nameCandidatePresident2=name;
			}else{
				return false;
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Sets the names of the presidential candidates by combining their first and last name
	 * Only works if the amount of votes for the president is equal to 0
	 * This in order to prevent fraud during the election
	 * @param first1 first name of the first candidate
	 * @param last1 last name of the first candidate
	 * @param first2 first name of the second candidate
	 * @param last2 last name of the second candidate
	 * @return true if successful, false if the amount of votes was not equal to 0
	 */
	public static boolean setCandidatesPresident(String first1, String last1, String first2, String last2){
		if(votesCandidatePresident1.equals(BigInteger.ZERO)&&votesCandidatePresident2.equals(BigInteger.ZERO)){
			nameCandidatePresident1=first1+" " + last1;	//Add a space in between the first and last name
			nameCandidatePresident2=first2+" " + last2;
			return true;
		}else{
			return false;
		}
	}


	/**
	 * Only works if the amount of votes for the president is equal to 0
	 * This in order to prevent fraud during the election
	 * @param index 1 or 2 depending on which candidates name to change
	 * @param first first name that you want the new candidate to have
	 * @param last last name that you want the new candidate to have
	 * @return true if successful, false if the amount of votes was not 0 or the index was not 1 or 2
	 */
	public static boolean setCandidatesPresident(int index, String first, String last){
		if(votesCandidatePresident1.equals(BigInteger.ZERO)&&votesCandidatePresident2.equals(BigInteger.ZERO)){
			if(index==1){
				nameCandidatePresident1=first+" " + last;
			}else if (index==2){
				nameCandidatePresident2=first+" " + last;
			}else{
				return false;
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Only works if the amount of votes for the president is equal to 0
	 * This in order to prevent fraud during the election
	 * @param candidate1 Name that you want to set the first candidate of vice president to
	 * @param candidate2 Name that you want to set the second candidate of vice president to
	 * @return true if successful, false if the amount of votes was not equal to 0
	 */
	public static boolean setCandidatesVicePresident(String candidate1, String candidate2){
		if(votesCandidatePresident1.equals(BigInteger.ZERO)&&votesCandidatePresident2.equals(BigInteger.ZERO)){
			nameCandidateVicePresident1=candidate1;
			nameCandidateVicePresident2=candidate2;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Resets all the votes to 0,
	 * Also sets the amount of voters to 0
	 */
	public static void resetVotes(){
		votesCandidatePresident1=BigInteger.ZERO;
		votesCandidatePresident2=BigInteger.ZERO;
		votesCandidateVicePresident1=BigInteger.ZERO;
		votesCandidateVicePresident2=BigInteger.ZERO;
		voters=BigInteger.ZERO;
	}


	/**
	 * Returns a string with a , as delimiter with the votes for both candidates for presidents
	 * @return string in the format [votesPresident1,votesPresident2]
	 */
	public static String getCurrentVotePresident(){
		return votesCandidatePresident1.toString() + "," + votesCandidatePresident2.toString();
	}

	/**
	 * Returns a string with a , as delimiter with the votes for both candidates for Vice Presidents
	 * @return string in the format [votesVicePresident1,votesVicePresident2]
	 */
	public static String getCurrentVoteVicePresident(){
		return votesCandidateVicePresident1.toString() + "," + votesCandidateVicePresident2.toString();
	}

	/**
	 * Gets the votes from a user and keeps on going until the user has entered votes that he also confirmed.
	 * It will then record those votes in the correct variables
	 */
	public void getAndConfirmVotes(){
		boolean temb = true;
		String temp = getVotes();
		String sub1 = temp.substring(0, temp.indexOf(","));
		String sub2 = temp.substring(temp.indexOf(",")+1);
		while(temb){

			if(confirmVotes(Integer.valueOf(sub1), Integer.valueOf(sub2))){
				recordVotes(Integer.valueOf(sub1),Integer.valueOf(sub2));
				temb=false;
			}else{
				temp = getVotes();
				sub1 = temp.substring(0, temp.indexOf(","));
				sub2 = temp.substring(temp.indexOf(",")+1);
			}
		}
	}

	/**
	 * Gets a single vote for either the president or for the vice president.
	 * It uses the names of the candidates to check if it should ask for the vice president vote or for the president vote
	 * 
	 * @param name1 Name of the first candidate, this must be a valid name for either the president or the vice president
	 * @param name2 Name of the second candidate, this must be a valid name for either the president or the vice president
	 * @return 0 if no vote cast, 1 if vote cast for name1, 2 if vote cast for name2
	 */
	private static int getAVote(String name1, String name2){
		if(name1.equals(nameCandidatePresident1)&&name2.equals(nameCandidatePresident2)){
			System.out.println("If you want " + name1 + " to be president please vote a 1.");
			System.out.println("If you instead want " + name2 + " to be president please vote a 2.");
		}else{
			System.out.println("If you want " + name1 + " to be vice president please vote a 1.");
			System.out.println("If you instead want " + name2 + " to be vice president please vote a 2.");

		}
		int temp=0;
		boolean tempB = true;
		System.out.println("Please enter your vote now:");
		temp = keyboard.nextInt();
		while(tempB){
			if (temp==1||temp==2||temp==0){
				tempB=false;
			}else{
				System.err.println("Invalid input, please enter your vote again");
				temp = keyboard.nextInt();
			}
		}
		return temp;


	}

	/**
	 * A method to get votes for this person for both the president and the vice president
	 * @return a string in the format [votePresident,voteVicePresident], where both votes are either 0 or 1 or 2
	 */
	private static String getVotes(){
		int votePresident=getAVote(nameCandidatePresident1,nameCandidatePresident2);
		int voteVicePresident = getAVote(nameCandidateVicePresident1,nameCandidateVicePresident2);
		return Integer.toString(votePresident) + "," + Integer.toString(voteVicePresident);
	}

	/**
	 * Method that checks with the voter if his votes are correct
	 * @param president 1 for the first candidate, a 2 for the second candidate for president
	 * @param vicePresident 1 for the first candidate, a 2 for the second candidate for president
	 * @return true if the vote was confirmed to be true, false if the vote was incorrect
	 */
	private static boolean confirmVotes(int president, int vicePresident){
		boolean confirmed = false;
		if(president==0){
			System.out.println("You have entered that you do not care who the president is.");
		}else{
			System.out.print("You have entered that you want to have ");
			if(president==1){
				System.out.print(nameCandidatePresident1);
			}else{
				System.out.print(nameCandidatePresident2);
			}
			System.out.println(" as president");
		}
		if(vicePresident==0){
			System.out.println("You have also entered that you do not mind who the vice president is");
		}else{
			System.out.print("You have also entered that you want to have ");
			if(vicePresident==1){
				System.out.print(nameCandidateVicePresident1);
			}else{
				System.out.print(nameCandidateVicePresident2);
			}
			System.out.println(" as vice president.");
		}
		System.out.println();
		System.out.println("If you still agree with these votes please say yes, otherwise say no.");
		String temp = "";
		boolean tempB=true;

		while(tempB){
			temp = keyboard.next();
			if (temp.equalsIgnoreCase("yes")){
				confirmed = true;
				tempB=false;
				System.out.println("Confirmed, saving vote");
			}else if(temp.equalsIgnoreCase("no")){
				confirmed = false;
				tempB=false;
				System.out.println("Unconfirmed, please re enter your vote");
			}else{
				System.out.println("I could not understand what you entered, can you please enter it again?");
			}
		}		
		return confirmed;
	}

	/**
	 * This method will be run after votes have been confirmed and stores the votes in the correct variables.
	 * @param president The vote for president
	 * @param vicePresident The vote for vice president
	 */
	private void recordVotes(int president, int vicePresident){
		myVoteForPresident=president;	
		if(president==1){
			votesCandidatePresident1=votesCandidatePresident1.add(BigInteger.ONE);
		}else if(president==2){
			votesCandidatePresident2=votesCandidatePresident2.add(BigInteger.ONE);;
		}
		
		myVoteForVicePresident=vicePresident;	
		if(vicePresident==1){
			votesCandidateVicePresident1=votesCandidateVicePresident1.add(BigInteger.ONE);
		}else if(vicePresident==2){
			votesCandidateVicePresident2=votesCandidateVicePresident2.add(BigInteger.ONE);
		}
	}
	
	/**
	 * Closes the Scanner that is used to get keyboard input.
	 * Closes the whole program using a System exit with code 0
	 */
	public static void close(){
		keyboard.close();
		System.exit(0);
	}



}
