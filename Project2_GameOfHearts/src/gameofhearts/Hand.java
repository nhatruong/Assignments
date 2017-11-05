package gameofhearts;

public class Hand extends GroupOfCards {
	
	public final int NUM;
	private int shortest =0;
	
	public Hand(int playerNum, int numberOfCards) {
		super(numberOfCards);
		NUM=playerNum;
	}
	public void sort() {
		
		Card[] tempCards =super.getCardArray();
		Card temp;
		int min;
		
		for(int out=0; out<super.getCurrentSize()-1; out++) {
			min =out;			
			for(int in =out+1; in<super.getCurrentSize(); in++) {
				if((tempCards[in].getSuit()*13 + tempCards[in].getNum()) <
						(tempCards[min].getSuit()*13 +tempCards[min].getNum())) {
					temp = tempCards[min];
					tempCards[min]= tempCards[out];
					tempCards[out]= temp;
				}								
			}			
		}
	}
	public void setShortest() {		
		int clubsCount=0, diamondsCount=0, heartsCount=0, spadesCount=0;
		//count suit
		for(int i =0; i<= getCurrentSize()-1; i++) {
			if(getCard(i).getSuit()==0) {
				clubsCount =findCount(getCard(i).getSuit());
			}
			else if(getCard(i).getSuit()==1) {
				diamondsCount =findCount(getCard(i).getSuit());
			}
			else if(getCard(i).getSuit()==2) {
				heartsCount =findCount(getCard(i).getSuit());
			}
			else if(getCard(i).getSuit() ==3) {
				spadesCount =findCount(getCard(i).getSuit());
			}
		}									
		//set shortest
		if(diamondsCount <= clubsCount) {
			shortest=1;
		}
		if((spadesCount <=clubsCount || spadesCount <=diamondsCount) &&
			((find(12, 2)!=-1) || (find(13, 2) !=-1)|| (find(14, -1)!=-1))) {
			shortest = 3;
		}
	}
	//return the index of the lowest card in the a suit
	public int findLowest(int suit) {
		int lowestSuitNumberIndex =-1;
		int lowestNumber=14;
		for(int i=0; i<=getCurrentSize()-1; i++) {
			if(getCard(i).getSuit()==suit && getCard(i).getNum() <lowestNumber) {
				lowestNumber = getCard(i).getNum();
				lowestSuitNumberIndex =i;				
			}
		}		
		return lowestSuitNumberIndex;
	}
	public int getShortest() {
		return shortest;
	}
	public Card playACard(Game game, Trick trick) {
		
		int index=-1;
		if(trick.getCurrentSize()==0) {
			setShortest();
			index= findHighest(shortest);
		}
		else if((Deck.TOTAL_CARDS-trick.getCurrentSize()-1) ==1) {
			if(!trick.getHearts() || !trick.getQueen()) {
				index =findHighest(getShortest());
			}
		}
			
		return getCard(index);
		
	}
	//number of card in a suit
	private int findCount(int suit) {
		int numberOfCardInASuite=0;
		for(int i=0; i<=getCurrentSize()-1;i++) {
			Card card= getCard(i);
			if(card.getSuit() == suit) {
				numberOfCardInASuite++;
			}
		}
		return numberOfCardInASuite;
	}
	//find a particular card per num and suit
	private int find(int num, int suit) {
		int found=-1;
		for(int i=0; i<= super.getCurrentSize()-1; i++) {
			Card card = super.getCard(i);
			if(card.getNum()==num && card.getSuit()==suit) {
				found =i; break;
			}
		}
		return found;
	}
	//find the highest card number in a suit
	private int findHighest(int suit) {
		int highestNumberCardPerSuit =-1;
		int temp =2;
		for(int i=0; i<= getCurrentSize()-1; i++) {
			Card card = getCard(i);
			if(card.getSuit()==suit && card.getNum() >temp) {				
				highestNumberCardPerSuit =i;
				temp =card.getNum();
			}
		}
		return highestNumberCardPerSuit;
	}
	//return index of highest card below the queen
	private int findLastHigh(int suit) {
		int tempNumber=2;
		int indexOfHighestCardInSuit = findHighest(suit);
		Card card = getCard(indexOfHighestCardInSuit);
		//filter out queen of spades
		if(card.getSuit()==3 && card.getNum()==12) {
			//find other spades in the hand
			if(findCount(3) >0) {
				for(int i=0; i<= getCurrentSize()-1; i++) {
					if(getCard(i).getSuit()==3 && getCard(i).getNum() > tempNumber) {
						indexOfHighestCardInSuit =i;
						tempNumber=getCard(i).getNum();
					}
				}
			}
		}
		return indexOfHighestCardInSuit;				
	}
	
	private int findHighestBelow(Card winningcard) {
		int index =-1;
		int winningSuite = winningcard.getSuit();
		int winningNumber = winningcard.getNum();
		for(int i=0; i<=getCurrentSize()-1; i++) {
			if(findCount(winningSuite) > 0 && getCard(i).getNum() < winningNumber) {
				index=i; break;
			}
		}
		return index;
	}
	private int findMiddleHigh(Game game, int suit) {
		int index=-1;
		
		return index;
	}
}
