package gameofhearts;

import java.util.Arrays;

public class GroupOfCards {
	private Card[] cards;
	private int currentSize =0; //length
	
	public GroupOfCards(int num) {
		cards = new Card[num];		
	}
	public int getCurrentSize() {
		return currentSize;
	}
	public Card getCard(int i) {
		return cards[i];
	}
	public void addCard(Card card) {
		cards[currentSize]= card;
		currentSize++;
	}
	public Card[] getCardArray() {
		return cards;
	}
	public Card removeCard(int index) {
		Card c = cards[index];
		Card[] temp= Arrays.copyOf(cards, currentSize);
				
		for(int i=index+1; i<=currentSize-1; i++) {
			cards[i-1]= temp[i];
		}
	
		
		temp=null;
		currentSize--;
		return c;		
	}
	public void display() {
		for(Card c : cards) {
			c.display();
		}
	}

}
