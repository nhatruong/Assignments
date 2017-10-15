package tool;


public class Tool {
	private int strength;
	private char type;

	public Tool() {
				
	}
	public Tool(int strength, char type) {
		this.strength = strength;
		this.type = type;		
	}
	
	public void setStrength(int strength){
		this.strength = strength;
	}
	public int getStrength() {
		return this.strength;
	}
	public int doubleStrength() {
		 return this.getStrength() *2;
	}
	public int halfStrength() {
		return this.getStrength() /2;
	}
}
