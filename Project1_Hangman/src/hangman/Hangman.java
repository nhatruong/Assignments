package hangman;

import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;



public class Hangman {

	private ArrayList<String> wordsList= new ArrayList<String>();

	private ArrayList<Character> correctList = new ArrayList<Character>();

	

	

	private String selectedWord="";

	int wrongGuess=0;

	int correctGuess =0;

	final int maxWrongGuess = 8;

	char guessLetter=' ';

	public Hangman() {	

	}

	public Hangman(ArrayList<String> words) {

		this.wordsList =words;

	}

	

	public void playGame() {

		//choose a word

		chooseWord();

		//print welcome message

		System.out.println("Welcome to the HangMan game.\nBelow is the dashes"

				+ " that corresponds to each letter of a hidden word."+	" There"

				+ " are " + selectedWord.length() +" letters in this word.");

		

		//display dashes per word

		for(int i =0; i <=selectedWord.length()-1; i++) {

			correctList.add('_'); 

			System.out.print("_ ");

		}

		

		//ask user to guess

		System.out.println("");

		System.out.println("To start the game, select a letter from your keyboard" 

			+" and press the Enter key.");

		handleGuess();

					

	}

	public void handleGuess() {

		while(wrongGuess < maxWrongGuess) {

			System.out.println("Select a letter ");

			Scanner scanInput = new Scanner(System.in);

			String userGuess = scanInput.next().toUpperCase(); 

		

			

			if(userGuess.length() >1 || isWrongGuess(userGuess)) {

				wrongGuess++;

				printHangman();

				displayWord();

		

				System.out.println();

			}

			else {

				correctGuess++;

				guessLetter = userGuess.charAt(0);		

			

				for(int i=0; i <= selectedWord.length()-1; i++) {

					if(guessLetter ==selectedWord.charAt(i)) {

						correctList.set(i, guessLetter); 

					}

				}

				displayWord();

				//check if user won the game

				if(gameWon()) {

					break;

				}		

			}

			System.out.println();		

		} //EXIT WHILE LOOP

		

		//lost the game

		if(wrongGuess >= maxWrongGuess) {

			gameOver();

		}

		//win the game

		else {

			System.out.println("\nCongratualtions!!! you have won the game.");

		}

		

	}

	public void chooseWord() {

		

		Random random = new Random();

		int wordIndex = random.nextInt(wordsList.size());

		

		selectedWord = wordsList.get(wordIndex).toUpperCase();				

	}

	public void gameOver() {

		System.out.println("You have made more than "+wrongGuess +" guesses." 

				+ "Sorry, you have lost the game. Game is over!!!");

	}

	public boolean gameWon() {

		boolean isWinner = false; //not a winner

		if(correctList.indexOf('_') == -1) {

			isWinner = true;	//winner		

		}

		return isWinner;

	}

	public void displayWord() {

		for(char i : correctList) {

			System.out.print(i+" ");

		}

	}

	

	//print hang man

	public void printHangman() {

		if(wrongGuess ==1) {

			printHead();

		}		

		else if(wrongGuess ==2) {

			printHead();printBody();

		}

		else if(wrongGuess ==3) {

			printHead();printBody();printLeftArm();

		}

		else if (wrongGuess ==4) {

			printHead();printBody();printRightArm();			

		}

		else if(wrongGuess ==5) {

			printHead();printBody();printRightArm();printLegs();

		}

		else if (wrongGuess ==6) {

			printHead();printBody();printRightArm();printLegs();

		}

		else if (wrongGuess ==7) {

			printHead();printBody();printRightArm();printLegs(); printLeftFoot();

		}

		else if (wrongGuess ==8) {

			printHead();printBody();printRightArm();printLegs(); printRightFoot();			

		}

	}

	//print head

	private void printHead() {

		System.out.println("\t\t\t|");

		System.out.println("\t\t\tO");

	}

	//print body

	private void printBody() {

		System.out.println("\t\t\t|");

		System.out.println("\t\t\t|");		

	}

	//print left arm

	private void printLeftArm() {

		System.out.println("\t\t    ----");

	}

	//print right arm

	private void printRightArm() {

		//reprint left arm without a new line

		System.out.print("\t\t    ----");

		System.out.println(" ----");

	}

	//print left leg

	private void printLegs() {

		//print left leg

		if(wrongGuess ==5) {

			System.out.println("\t\t       /");

			System.out.println("\t\t      /");

		}

		//print right leg

		else if(wrongGuess ==6 || wrongGuess==7 || wrongGuess ==8) {

			System.out.print("\t\t       /"); System.out.println(" \\");

			System.out.print("\t\t      /"); System.out.println("   \\");			

		}

		

	}

	private void printLeftFoot() {

		System.out.println("\t\t    --");

	}

	//print right foot

	private void printRightFoot() {

		//reprint left foot without a newline character

		System.out.print("\t\t    --");

		System.out.println("\t   --");

	}

	

	

	//check if a user guess is wrong. Return false if wrong guess

	private boolean isWrongGuess(String s) {

		char l =s.charAt(0);

		boolean isWrongLetter = true; //wrong guess

		if(selectedWord.indexOf(l) != -1) {

			isWrongLetter = false; //correct guess

		}

		return isWrongLetter;

	}

}
