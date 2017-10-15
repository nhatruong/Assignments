package tool;

public class Paper extends Tool {

	public Paper() {		
	}
	public Paper(int strength) {
		super(strength, 'p');
	}
	public boolean fight(Tool t) {
		boolean isWin =false;
		//fight against Scissors
		if(t instanceof Scissors ){
			
			if(super.halfStrength() > ((Scissors)t).getStrength())
			{
				isWin = true;
			}
		}
		//fight against Rock
		else if(t instanceof Rock) {
			
			if(super.doubleStrength()> ((Rock)t).getStrength()) {
				isWin = true;
			}			
		}
		return isWin;
	}
}
