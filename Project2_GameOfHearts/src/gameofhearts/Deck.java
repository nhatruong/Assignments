package gameofhearts;

public class Deck extends GroupOfCards {
	public static final int TOTAL_CARDS =52;
	public Deck() {
		super(TOTAL_CARDS);
		//Initialize card deck
		for(int i=2; i<=14; i++) {
			for(int j=0; j<=3; j++) {
				super.addCard(new Card(i, j));
			}
		}		
	}
	public void shuffle() {
		int size = super.getCurrentSize()-1;
		for(int i=0; i<=size; i++) {
			int index =(int)Math.floor(Math.random()*12);//0 to 13
			Card randomCard =super.removeCard(index); //get card at this index
			super.addCard(randomCard);
	
		}
	}
	public Card dealCard() {
		int index=0;
		Card card= removeCard(index); index++;
		return card;	
	}
}
