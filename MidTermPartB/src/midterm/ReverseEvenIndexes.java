package midterm;

import java.util.ArrayList;

public class ReverseEvenIndexes {
	
	public int[] reverseEventIndecies(int[] numbs) {
		int length = numbs.length;
		ArrayList<Integer> evenIndex = new ArrayList<Integer>();
		for(int i=0; i<= length-1; i++) {
			if(i%2 ==0) {
				evenIndex.add(numbs[i]);					
			}			
		}
	
		int len = evenIndex.size()-1;
		for(int i =0; i<=length-1; i++) {
			if(i%2 ==0) {
				numbs[i]= evenIndex.get(len);
				len--;
			}					
		}
		return numbs;		
	}


}
