package tool;

public class Scissors extends Tool {

	public Scissors() {		
	}
	public Scissors(int strength) {
		super(strength, 's');
	}
	public boolean fight(Tool t) {
		boolean isWin =false;
		//fight against paper
		if(t instanceof Paper ){
			
			if(super.doubleStrength()> ((Paper)t).getStrength())
			{
				isWin = true;
			}
		}
		//fight against Rock
		else if(t instanceof Rock) {			
			if(super.halfStrength() > ((Rock)t).getStrength()) {
				isWin = true;
			}			
		}
		return isWin;
	}
}
