package tool;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		Rock r = new Rock(15);
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		
		System.out.println(s.fight(p) + " , "+ p.fight(s));
		System.out.println(p.fight(r) + " , "+ r.fight(p));
		System.out.println(r.fight(s) + " , "+ s.fight(r));

	}

}
