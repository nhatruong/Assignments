package assignment7;

import java.util.Random;

public class MaxValue extends Thread {
	int[] testArray;
	int low;
	int hi;
	int max;
	public MaxValue(int[]arr, int low, int hi) {
		this.testArray =arr;
		this.low=low;
		this.hi=hi;
	}
	
	@Override
	public void run() {
		max =testArray[low];
		for(int i=low; i< hi; i++) {
			if(testArray[i]>max) {
				max=testArray[i];
			}
		}
	}
	public static int maxValue(int[] a) throws InterruptedException {
		MaxValue[] tMaxValue = new MaxValue[4]; //array of threads
		int[] maxElement = new int[4]; //store max element of each thread
		int l = a.length;
		for(int i=0; i<=tMaxValue.length-1;i++) {
			tMaxValue[i]= new MaxValue(a,(i*l)/4, (i+1)*l/4);
			tMaxValue[i].start();
			tMaxValue[i].join();
			maxElement[i]=tMaxValue[i].max; //store max element from each thread
		}
	
		int max = maxElement[0]; //find the max element
		for(int i=0; i<=maxElement.length-1;i++) {
			if(maxElement[i] > max) {
				max=maxElement[i];
			}
		}
		return max;
	}

	public static void main(String[] args) throws InterruptedException {
		int[] arr= new int[100];
		Random r = new Random();
		for(int i=0; i<=arr.length-1;i++) {
			arr[i]= r.nextInt(i+1);	
			//System.out.print(arr[i]+" ");
		}
		System.out.println("max element is "+ maxValue(arr));
	}

}
