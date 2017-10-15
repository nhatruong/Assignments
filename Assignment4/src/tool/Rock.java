package tool;

public class Rock extends Tool {

	public Rock() {		
	}
	public Rock(int strength) {
		super(strength, 'r');
	}
	public boolean fight(Tool t) {
		boolean isWin =false;
		//fight against paper
		if(t instanceof Paper ){
			
			if(super.halfStrength() > ((Paper)t).getStrength())
			{
				isWin = true;
			}
		}
		//fight against scissors
		else if(t instanceof Scissors) {			
			if(super.doubleStrength()> ((Scissors)t).getStrength()) {
				isWin = true;
			}			
		}
		return isWin;
	}
}
