package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AMTTest {
	private static Scanner sc = new Scanner(System.in);
	//private static
	public static void main(String[] args) {		
		//used to store ATM objects
		boolean isContinue =true;
		//keep track of ATM user
		ArrayList<ATM> atmList = new ArrayList<ATM>();
		ATM atm = new ATM();
		printInitialMessage();
		while(isContinue) {
			String option =sc.next();
			if(option.length() >1) {
				System.out.println(option +" is not valid. Try again");
				printInitialMessage();
				option= sc.nextLine();
			}
			else if(option.equalsIgnoreCase("n")) {
				printNewUserMessage();
			}
			else if(option.equalsIgnoreCase("e")) {
				atm.exit();
			}
			else if(option.equalsIgnoreCase("u")) {
				System.out.println("Enter the following info to create a new user");
				System.out.println("Enter your name:");
				String name= sc.next();
				System.out.println("Enter your age:");
				int age =Integer.parseInt(sc.next());
				System.out.println("Enter your address: ");
				String address =sc.next();
				System.out.println("Enter your phone: ");
				
				String phone =sc.next();
				ATM user= atm.createNewUser(name, age, address, phone);
			
				atmList.add(user);
				System.out.println("User created Successfully");
				System.out.println("Below is your password and account number");
				System.out.println("***********************************************");
				System.out.println("IMPORTANT!!!");
				System.out.println("your password is "+atm.getUserPassword());
				System.out.println("your bank number is "+atm.getBankAccountNumber());
				System.out.println("***********************************************");
				printInitialMessage();
			}
			else if(option.equalsIgnoreCase("c")) {
				printCurrentUserMessage();
			}
			else if(option.equalsIgnoreCase("r")) {
				System.out.println("Enter the following info to reset your password");
				System.out.println("Enter your name:");
				String name= sc.next();
				System.out.println("Enter your age:");
				int age =Integer.parseInt(sc.next());				
				System.out.println("Enter your phone: ");
				boolean isFound= false;
				String phone =sc.next();
				//check if user exists
				for(ATM atm2 :atmList) {
					HashMap<Integer, User> hMap = atm2.getUserData();
					for(User user : hMap.values()) {
						if(atm2.resetPassword(name, age, phone)) {
							System.out.println("Password reset successfully");
							isFound=true;
							break;
						}
						if(isFound) break;//get out of the first foreach loop
					}
				}
				//check if a user is found
				if(!isFound) {//no user exists
					System.out.println("not able to reset password");
				}
				printInitialMessage();
			}
			else if(option.equalsIgnoreCase("b")) {
				System.out.println("Enter the following info to check your balance");
				System.out.println("Log in to check your balance");
				System.out.println("Enter your bank account:");
				int bankAccount= Integer.parseInt(sc.next());
				System.out.println("Enter your password:");
				int password =Integer.parseInt(sc.next());	
				boolean isFound= false;
				//check if user exists
				for(ATM atm2 :atmList) {
					
					if(atm2.login(bankAccount, password)) {
						System.out.println("your balance is "+atm2.checkAvailableBalance());
						isFound=true;
						break;
					}										
				}
				//not found, can not login
				if(!isFound) {
					System.out.println("Can not log in. Try again");
				}
				printInitialMessage();
			}
			else if(option.equalsIgnoreCase("w")) {
				System.out.println("Log in to withdraw");
				System.out.println("Enter your bank account:");
				int bankAccount= Integer.parseInt(sc.next());
				System.out.println("Enter your password:");
				int password =Integer.parseInt(sc.next());
				System.out.println("Enter the withdrawal amount:");
				double amount =Double.parseDouble(sc.next());
				boolean isFound= false;
				for(ATM atm2 :atmList) {
					
					if(atm2.login(bankAccount, password)
							&& atm2.withDraw(amount) !=Double.MIN_VALUE) {
						
							System.out.println("after withdrawal of "+amount+" and a transaction fee "
									+ "of "+atm2.getTransactionFee()+". Your balance is "
									+ atm2.getAvailableAmountInMachine());
							isFound=true;
							break;
					}						
				}										
				
				//not found, can not login
				if(!isFound) {
					System.out.println("Can not withdraw. Try again");
				}
				printInitialMessage();
			}
			else if(option.equalsIgnoreCase("d")) {
				System.out.println("Log in to deposit");
				System.out.println("Enter your bank account:");
				int bankAccount= Integer.parseInt(sc.next());
				System.out.println("Enter your password:");
				int password =Integer.parseInt(sc.next());
				System.out.println("Enter deposit amount:");
				double amount =Double.parseDouble(sc.next());
				boolean isFound= false;
				for(ATM atm2 :atmList) {
					
					if(atm2.login(bankAccount, password) && atm2.deposit(amount) != Double.MIN_VALUE) {						
						System.out.println("after the transaction fee of "
								+atm2.getTransactionFee()+" your balance is "
								+ atm2.getAvailableAmountInMachine());
						isFound=true;
						break;												
					}										
				}
				if(!isFound) {
					System.out.println("Cant make deposit. Try again");
				}
				printInitialMessage();
			}
			else if(option.equalsIgnoreCase("l")) {
				System.out.println("Enter the following info to log in");
				System.out.println("Enter your bank account:");
				int bankAccount= Integer.parseInt(sc.next());
				System.out.println("Enter your password:");
				int password =Integer.parseInt(sc.next());
				boolean isFound =false;
				for(ATM atm2 :atmList) {
					if(atm2.login(bankAccount, password)) {
						System.out.println("login successfully");
						isFound=true;break;
					}					
				}
				if(!isFound) {
					System.out.println("User does not exist");
				}
				printInitialMessage();
			}
			else if (option.equalsIgnoreCase("t")) {
				System.out.println("Enter your bank account and password to print transaction history");
				System.out.println("Enter your bank account:");
				int bankAccount= Integer.parseInt(sc.next());
				System.out.println("Enter your password:");
				int password =Integer.parseInt(sc.next());
				for(ATM atm2 :atmList) {
					if(atm2.login(bankAccount, password)) {
						atm2.recentTransactions();
					}
				}
				printCurrentUserMessage();
			}
			else if(option.equalsIgnoreCase("i")) {
				printInitialMessage();
			}
			else {
				System.out.println("invalid selection. Try again");
				printInitialMessage();
			}
		}			
	}
	private static void printInitialMessage() {
		
		System.out.println("\nSelect one of the following options(letter), and press enter key");
		System.out.println("n - new user");
		System.out.println("c - current user");
		System.out.println("e - exit");
	}
	private static void printNewUserMessage() {
		
		System.out.println("\nSelect one of the following options(letter), and press enter key");
		System.out.println("u - create new user");	
		System.out.println("e - exit");
	}
	private static void printCurrentUserMessage() {
		
		System.out.println("\nSelect one of the following options(letter), and press enter key");
		
		System.out.println("i - back to initial message");
		System.out.println("r - reset password");
		System.out.println("b - check balance");
		System.out.println("w - withdraw");
		System.out.println("d - deposit");
		System.out.println("t - recent transactions");
		System.out.println("l - log in");
		System.out.println("e - exit");
	}

	
}
