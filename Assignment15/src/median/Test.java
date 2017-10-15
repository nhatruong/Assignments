package median;

public class Test {

	public static void main(String[] args) {
		int[] num1 = {1,3}; int[] num2 = {2,4};
		SortedArrayMedian s = new SortedArrayMedian();
		double median =s.findMedianSortedArrays(num1, num2);
		System.out.println("the median is "+ median);						
	}

}
