package midterm;

public class CountNumberOfPossibleWays {
	 public int countNumberofPossibleWays(int m, int n, int x) {
	    int possibleNumberOfWays = 0;
	    int diceValues[] = new int[n];
	    //no dice
	    if (n<=0) {
	    	return 0;
	    }
	    //one dice  
        if (n==1){
	        //only one dice, one face
	        if (x>=1 && x<=m){
	            return 1;
	        }
	        else {
	            return 0;
	        }	                
	    }
        //2 dices up
	    for(int i=1; i<=m; i++){
	        diceValues[n-1] = i;
	        possibleNumberOfWays += countNumberofPossibleWays(m,n-1, x-i);
	    }
	    return possibleNumberOfWays;
	}
}
