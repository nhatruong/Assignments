package assignment7;

public class PascalTriangle {

	public static void printPascalTriangle(int n){
        //number of row
	 for(int row=0; row<=n-1;row++) {
		 //number of element in each row
		 for(int element=0; element<= row; element++) {
			 System.out.print(biCoefficient(row,element)+" ");
		 }
		 System.out.println("");
	 }
  }
 //compute each binomial coefficient for elements in each row
 private static int biCoefficient(int row, int element) {
	 int numerator= factorial(row);
	 int denominator=factorial(element)*factorial(row-element);
	 int result=(int)numerator/denominator;
	 	 return result;
 }
 
 private static int factorial(int number) {
	 int result = 1;
       for (int i = 1; i <= number; i++) {
           result = result * i;
       }
       return result;
 }

public static void main(String[] args) {
	printPascalTriangle(5);

}


}
