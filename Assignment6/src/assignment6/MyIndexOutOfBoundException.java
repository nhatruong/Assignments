package assignment6;

public class MyIndexOutOfBoundException extends Exception {

	private int lowerBound;
	private int upperBound;
	private int index;
	
	public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {		
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}
	public String toString() {
		return "Error Message: Index: " +index+", but Lower bound: "+lowerBound+", Upper bound: "+upperBound;
	}
	public static void indexOutofBoundException(int lowerBound, int upperBound, int index) 
		throws MyIndexOutOfBoundException{
		if(index >=10) {
			throw new MyIndexOutOfBoundException(lowerBound, upperBound, index);
		}
	}
			
	public static void main(String[] args) {
		//System.out.println(System.nanoTime());
		//System.out.println(System.currentTimeMillis());
		try {
			MyIndexOutOfBoundException.indexOutofBoundException(0, 9, 10);
		}
		catch(MyIndexOutOfBoundException ex) {
			System.out.println(ex);			
		}
	}

}
