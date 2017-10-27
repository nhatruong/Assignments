package midterm;

public class ArrangeCoins {
	public int arrangeCoins(int n) {
		int fullRow=0;
		
		if(n==0) {
			fullRow =0;
		}
		else {
			while(true) {
				fullRow++;
				n= n- fullRow;
				if(n < 0) {
					fullRow--; break;
				}		
			}
		}
		
		return fullRow;
	}

}
