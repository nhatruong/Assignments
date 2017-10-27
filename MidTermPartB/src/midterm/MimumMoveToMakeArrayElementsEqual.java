package midterm;

import java.util.Arrays;

public class MimumMoveToMakeArrayElementsEqual {
	
	public static void main(String args[]) {
		int a[]= {2,3};
		System.out.println("min move: "+minMoves(a));
	}
	public static int minMoves(int[] nums) {
		int minMove=0;
		Arrays.sort(nums);
		int maxElement= nums[nums.length-1]; 
		for(int i : nums) {
			minMove += maxElement-i;
			if(i==maxElement) break;
		}
		return minMove;
	}
}
