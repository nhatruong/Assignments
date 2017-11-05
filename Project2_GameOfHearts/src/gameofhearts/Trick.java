package gameofhearts;

public class Trick extends GroupOfCards {
	private int winner=-1;
	private Card winningCard =null;
	private boolean hearts=false;
	private boolean queen =false;
	
	public Trick(int players) {
		super(2*players -1);
	}
	public int getWinner() {
		return winner;
	}
	public Card getWinningCard() {
		return winningCard;
	}
	public boolean getHearts() {
		return hearts;
	}
	public boolean getQueen() {
		return queen;
	}
	//call this every time a card adding to the trick
	public void update(int playNumber, Card card) {
		if(isWinner(card)) {
			winner = playNumber;
			winningCard = card;
			addCard(card);
		}
		//set hearts
		if(card.getSuit()==2) {
			hearts=true;
		}
		//set queen of spades
		else if(card.getSuit()==12 && card.getNum()==3) {
			queen=true;
		}
	}
	
	private boolean isWinner(Card card) {
		int winAll=0;
		boolean isWinner =true; 
		int cardSuit = card.getSuit();
		int cardNumber = card.getNum();
		//first card of the trick is the winning card
		if(winningCard==null) {
			winningCard= card;
		}
		//compare to other cards in the trick
		else {
			for(int i=0; i<= getCurrentSize()-1; i++) {
				if((cardSuit == getCard(i).getSuit()) && (cardNumber > getCard(i).getNum())) {
					winAll++;
				}
			}
			if(winAll < getCurrentSize()-1) {
				isWinner =false;
			}			
		}		
		return isWinner;
	}
}
