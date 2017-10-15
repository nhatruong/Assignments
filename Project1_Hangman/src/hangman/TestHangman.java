package hangman;

import java.util.ArrayList;

public class TestHangman {
	public static void main(String[] args) {

		ArrayList<String> words= new ArrayList<String>();

		words.add("NhatTruong");

		words.add("JasonTruong");

		words.add("Seattle");

		Hangman hm = new Hangman(words);

		hm.playGame();
	}
}
