package midterm;

public class Cell {
	int x,y;
	public Cell() {
		// TODO Auto-generated constructor stub
	}
	Cell(int x, int y){
		this.x =x;
		this.y=y;
	}
	public String toString() {
		return"["+this.x +", "+this.y+ "]";
	}	
}
