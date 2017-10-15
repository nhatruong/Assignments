package median;

import java.util.Arrays;

public class SortedArrayMedian {
	int[] nums3 =null;
	
	public double  findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median=0.0;
		int[] nums3 = new int[nums1.length +  nums2.length];
		System.arraycopy(nums1, 0, nums3, 0, nums1.length);
		System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
		Arrays.sort(nums3);
		int length = nums3.length;
		if(length % 2 == 0) {
			median = (nums3[(int) (Math.floor((length-1)/2))] +nums3[length/2])/2f;		
		}
		else {
			median = nums3[(length -1)/2];
		}
		return median;
	}
	
	

}
