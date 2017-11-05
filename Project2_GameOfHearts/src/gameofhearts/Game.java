package gameofhearts;

public class Game {
	public final int PLAYER;
	private Deck deck;
	private Hand[] players;
	private Trick[] tricks;
	private int numberOfTricks =0;
	private boolean hearts =false;
	private boolean queenOfSpades=false;
	
	public Game(int numberOfPlayers) {
		PLAYER=numberOfPlayers;
		deck = new Deck();
		players = new Hand[PLAYER];
		
		//initialize hand objects
		for(int i=0; i<= numberOfPlayers-1; i++) {
			players[i]= new Hand(i, (int)Deck.TOTAL_CARDS/numberOfPlayers);				
		}
		
		//instantiate Trick array
		numberOfTricks=(int)Deck.TOTAL_CARDS/numberOfPlayers;
		tricks = new Trick[numberOfTricks];		
	}
	public int getNumberOfTricks() {
		return numberOfTricks;
	}
	public boolean getHearts() {
		return hearts;
	}
	public boolean getQueenOfSpades() {
		return queenOfSpades;
	}
	public void playAGame() {
		//System.out.println("number of tricks "+ numberOfTricks);
		int count=0;
		deck.shuffle();
		int cardsLeft = Deck.TOTAL_CARDS % PLAYER;
		
		//deal cards
		while(count <=numberOfTricks-1) {
			for(int i=0; i<=PLAYER-1; i++) {
				players[i].addCard(deck.dealCard());					
			}
			count++;		
		}	
		//sort
		System.out.println("Output - first part:");
		for(int i=0; i<= players.length-1; i++) {
			Hand hand= players[i];
			hand.sort(); hand.setShortest();
			
			System.out.println("\tPlayer "+i+ " shortest is "+hand.getShortest());
			for(int j=0; j<=hand.getCurrentSize()-1; j++) {
				
				hand.getCard(j).display();
			}
		}
		System.out.println("output - second part");
		for(int j=0; j<= numberOfTricks-1; j++) {
				Card card;
				tricks[j]=new Trick(PLAYER);
				for(int i=0; i<= PLAYER-1; i++) {
						card=players[i].getCard(i);
						tricks[j].addCard(card); 
						tricks[j].update(0, card);
						if(tricks[j].getWinner() >-1){
							System.out.print("player "+i +" ");
							card.display();
						}
					}
		}				
	}
	private int computePoints(int playerNum) {
		int pointCount=0;
		for(int i=0; i<= tricks.length-1; i++) {
			if(tricks[i].getCard(i).getNum()==12 && tricks[i].getCard(i).getSuit()==3) {
				pointCount= pointCount+13;
			}
		}
		return pointCount;
	}
}
