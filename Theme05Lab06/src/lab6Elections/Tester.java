package lab6Elections;

import java.util.Random;

/*
 * Definition found on blackboard:
 * Elections: 
 * Write a program that will record the votes for one of two candidates by using the class 
 * VoteRecorder, which you will design and create. Vote Recorder will have static variables 
 * to keep track of the total votes for candidates and instance variables to keep track of 
 * the votes made by a single person. It will have the following attributes: 
 * 
 * • nameCandidatePresident1—a static string that holds the name of the first candidate for president 
 * • nameCandidatePresident2—a static string that holds the name of the second candidate for president 
 * • nameCandidateVicePresident1—a static string that holds the name of the first candidate for vice president 
 * • nameCandidateVicePresident2—a static string that holds the name of the second candidate for vice president 
 * 
 * • votesCandidatePresident1—a static integer that holds the number of votes for the first candidate for president 
 * • votesCandidatePresident2—a static integer that holds the number of votes for the second candidate for president 
 * • votesCandidateVicePresident1—a static integer that holds the number of votes for the first candidate for vice president 
 * • votesCandidateVicePresident2—a static integer that holds the number of votes for the second candidate for vice president 
 * 
 * • myVoteForPresident—an integer that holds the vote of a single individual for president (0 for no choice, 1 for the first candidate, and 2 for the second candidate) 
 * • myVoteForVicePresident—an integer that holds the vote of a single individual for vice president (0 for no choice, 1 for the first candidate, and 2 for the second candidate) 
 * 
 * In addition to appropriate constructors, VoteRecorder has the following methods: 
 * 
 * • setCandidatesPresident(String name1, String name2)—a static method that sets the names of the two candidates for president 
 * • setCandidatesPresident(int index, String name)—a static method that sets the name of one of the two candidates for president depending on the value of index 
 * • setCandidatesPresident(String first1, String last1, String first2, String last2)—a static method that sets the names of the two candidates for president by combining their first and last name 
 * • setCandidatesPresident(int index, String first, String last)—a static method that sets the of one of the two candidates for president depending on the value of index by combining their first and last name. 2 
 * • setCandidatesVicePresident(String name1, String name2)—a static method that sets the names of the two candidates for vice president 
 * 
 * • resetVotes—a static method that resets the vote counts to zero 
 * • getCurrentVotePresident—a static method that returns a string with the current total number of votes for both presidential candidates 
 * • getCurrentVoteVicePresident—a static method that returns a string with the current total number of votes for both vice presidential candidates 
 * 
 * • getAndConfirmVotes—a nonstatic method that gets an individual’s votes, confirms them, and then records them. 
 * • getAVote(String name1, String name2)—a private method that returns a vote choice for a single race from an individual (0 for no choice, 1 for the first candidate, and 2 for the second candidate) 
 * • getVotes—a private method that returns a vote choice for president and vice president from an individual 
 * • confirmVotes—a private method that displays a person’s vote for president and vice president, asks whether the voter is happy with these choices, and returns true or false according to a yes-or-no response 
 * • recordVotes—a private method that will add an individual’s votes to the appropriate static variables
 * 
 * Create a program that will conduct an election. 
 * The candidates for president are Annie Kennedy and Bob Hope. 
 * The candidates for vice president are John McCain and Susan Bush.
 * Use a loop to record the votes of many voters. 
 * Create a new VoteRecorder object for each voter.
 * After all the voters are done, present the results. 
 * In addition, write a test program to test the various methods for setting the names of the candidates for president.
 */

/*
 * My interpretation:
 * There will be one voteRecorder class, this will have the total amount of votes, names of candidates etc as a static
 * there will be instance variables for what the individual has voted.
 */


/**
 * @author Ylva
 * 
 *
 */
public class Tester {

	public static void main(String[] args) {
		System.out.println("Setting the president names");
		if(!VoteRecorder.setCandidatesPresident("Annie Kennedy", "Bob Hope")){
			System.err.println("Hmmm something went wrong...");
		}
		if(!VoteRecorder.setCandidatesVicePresident("John McCain", "Susan Bush")){
			System.err.println("Whoops programming error :O");
		}
		printVotes();
		System.out.println("Seems that the program so far runs okay.");
		System.out.println("We checked if we can enter names and if the amount of votes start at the correct number.");
		System.out.println("Time to do some voting");
		System.out.println("We will start with doing some manual voting, this is the kind of voting that should happen during elections.");
		System.out.println("I will let you enter 10 votes for both the president and the vice president:");
		
		int i =0;
		while(i<10){
			VoteRecorder voter = new VoteRecorder();
			voter.getAndConfirmVotes();
			i++;
		}
		printVotes();
		System.out.println("Now I won't let you sit here the whole day entering votes, I created a backway to simulate votes.");
		System.out.println("I am going to use this backway to simulate 10 000 votes for you.");
		System.out.println("This backway will work using a random number generator.");
		System.out.println("But let me start with reseting the vote count.");
		VoteRecorder.resetVotes();
		System.out.println("We can check if this method works, the following next lines should all tell us that there are 0 votes for all candidates:");
		printVotes();
		System.out.println("So resetting also works, now let me try simulating 1 vote:");
		Random rand = new Random();
		int randomPresident = rand.nextInt(2)+1;	//the nextInt is normally exclusive of the top value, so giving it 2 as a input will generate either a 0 or a 1, adding 1 to this and we have our vote
		int randomVicePresident = rand.nextInt(2)+1;
		VoteRecorder randomVote = new VoteRecorder(randomPresident,randomVicePresident);
		System.out.println("Checking what the votes are:");
		printVotes();
		System.out.println("I will now simulate 1 000 000 votes.");
		i=0;
		while(i<1000000){
			randomPresident = rand.nextInt(2)+1;
			randomVicePresident = rand.nextInt(2)+1;
			VoteRecorder simulatedVote = new VoteRecorder(randomPresident,randomVicePresident);
			i++;
		}
		printVotes();
		System.out.println("As you can see, using a random number generator is not the most accurate way to simulate an election.");
		System.out.println("This because there is a 50 50 change for each president to get a vote," + System.lineSeparator() + "If I would let this program simulate 1 000 000 000 000 votes we would still only see a minute difference.");
		System.out.println("But it'll do for testing the VoteRecorder class." + System.lineSeparator());
		System.out.println("Now lets see if we can change the names of the candidates...");
		if(!VoteRecorder.setCandidatesPresident("Thies Keulen", "Chris Mosterd")){
			System.out.println("Aww we cannot change the names for presidents during an election :(");
		}
		System.out.println("Lets try vice president?");
		if(!VoteRecorder.setCandidatesVicePresident("Thies Keulen", "Chris Mosterd")){
			System.out.println("Nope, even vice president wont do the trick");
		}
		
		System.out.println();
		System.out.println("We tested everything, time to close things down...");
		
		System.out.println("Bye, Bye");
		VoteRecorder.close();
		
	}

	/**
	 * Just prints the current vote count for all candidates
	 */
	public static void printVotes(){
		System.out.println();
		System.out.println("Checking what the vote counts of all presidential candidates are:");
		System.out.println("There are a total of " + VoteRecorder.getCurrentVotePresident().substring(0, VoteRecorder.getCurrentVotePresident().indexOf(",")) + " votes cast for the first presidential candidate which is named " + VoteRecorder.getNameCandidatePresident1() + ".");
		System.out.println("There are a total of " + VoteRecorder.getCurrentVotePresident().substring(VoteRecorder.getCurrentVotePresident().indexOf(",")+1) + " votes cast for the second presidential candidate which is named " + VoteRecorder.getNameCandidatePresident2() + ".");
		
		System.out.println();
		System.out.println("Now checking the vice president:");
		System.out.println("Up till now the candidate for vice president " + VoteRecorder.getNameCandidateVicePresident1() + " has gotten " + VoteRecorder.getCurrentVoteVicePresident().substring(0, VoteRecorder.getCurrentVoteVicePresident().indexOf(",")) + " votes.");
		System.out.println("Up till now the candidate for vice president " + VoteRecorder.getNameCandidateVicePresident2() + " has gotten " + VoteRecorder.getCurrentVoteVicePresident().substring(VoteRecorder.getCurrentVoteVicePresident().indexOf(",")+1) + " votes.");
		System.out.println();
	}
}
