package assignment7;
public class ReverseHello extends Thread {
	private static int threadNumber=1;
	private String greeting;
	 public ReverseHello(String g) {
	  super("Thread " + threadNumber);	  
		 this.greeting=g;
		 threadNumber++;
	 }
	  
	 public void run()
	 {	   
		 if(threadNumber <= 51)
		 {
			 ReverseHello reverseHelloTh = new ReverseHello("Hello from ");
			 reverseHelloTh.start();
			 try {
				 reverseHelloTh.join();
				 System.out.println(greeting+ getName()+"!"); 
			 }
			 catch (Exception e)
			 {
	   
			 }
		 }
	 } 
	 
	 public static void main (String args[])
	 {		 
		 ReverseHello reverseHelloTh = new ReverseHello("Hello from ");
		 reverseHelloTh.start();
	 }
}
