package gameofhearts;

public class Card {
	private int num;
	private int suit;
	
	public Card(int num, int suit) {
		this.num =num;
		this.suit =suit;
	}
	public int getNum() {
		return num;
	}
	public int getSuit() {
		return suit;
	}
	public void display() {
		switch (num) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10: 
			System.out.print(num); 
			//print suit
			displaySuit();
			break;
		case 11:
			System.out.print("Jack");
			displaySuit();
			break;
		case 12:
			System.out.print("Queen"); 
			displaySuit();
			break;
		case 13:
			System.out.print("King"); 
			displaySuit();
			break;
		case 14:
			System.out.print("Ace");
			displaySuit();break;		
		}	
	}
	private void displaySuit() {
		switch (suit) {
		case 0:
			System.out.println(" of Clubs"); break;			
		case 1:
			System.out.println(" of Diamonds"); break;
		case 2:
			System.out.println(" of Hearts"); break;
		case 3:
			System.out.println(" of Spades"); break;		
		}
	}

}
