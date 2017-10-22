package assignment6;


import java.util.ArrayList;
import java.util.HashMap;

public class ATM {
	private double availableAmountInMachine;
	final private double transactionFee;//in dollar
	private HashMap<Integer, User> userData = new HashMap<Integer, User>(); //store password as key to a specific User
	ArrayList<String> transactionType = new ArrayList<String>();
	ArrayList<Double> transactionAmount = new ArrayList<Double>();
	//keep each user password and bank account number
	private int userPassword; private int bankAccountNumber;
	private boolean isLogin =false;
	
	private static int password=0;
	public ATM() {		
		transactionFee= 1;
	}
	ATM(double amount, HashMap<Integer, User> Data){
		this.availableAmountInMachine =amount;
		this.transactionFee = 1;
		this.userData = Data; 
	}
	ATM(HashMap<Integer, User> Data){
		this.availableAmountInMachine =0.0;
		this.transactionFee =1;
		this.userData = Data; 
	}

	public void setAvailableAmountInMachine(double amt) {
		availableAmountInMachine = amt;
	}
	public double getAvailableAmountInMachine() {
		return availableAmountInMachine;
	}

	public void setUserData(HashMap<Integer, User> user) {
		userData =user;
	}
	public double getTransactionFee() {
		return transactionFee;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public HashMap<Integer, User> getUserData(){
		return userData;
	}
	public int getUserPassword() {
		return userPassword;
	}
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}
	//create new user
	public ATM createNewUser(String name, int age, String address, String phone) {
		User user = new User(name, age, address, phone);
		
		password++;
		//store new user
		userData.put(password, user);
		//store user password and bank number for test purpose
		bankAccountNumber= user.getBankAccountNumber();
		userPassword=password;
		return new ATM(userData);	
	}
	//current user login
	public boolean login(int accountNumber, int password) {		
		//validate user using account number and password		
		if(userData.get(password) != null 
				&& userData.get(password).getBankAccountNumber()==accountNumber) {
			isLogin =true;				
		}		
		return isLogin;
	}
	
	//reset password
	public boolean resetPassword(String name, int age, String phoneNumber) {
		boolean isResetSuccessful =false;
		//loop thru each user in the userData map
		for(int k :userData.keySet()) {
			User user = userData.get(k);
			if(user.getName().equalsIgnoreCase(name) &&
					user.getAge()== age && 
					user.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				//all match, reset password
				//remove old password, userData.
				userData.remove(k);
				//add new password
				userData.put(++password, user);
				isResetSuccessful =true;
				break;
			}
		}
		return isResetSuccessful;
	}

	public double checkAvailableBalance() {
		double amount=0.0;;
		if(isLogin) {
			amount =availableAmountInMachine;
		}
		else {
			amount=Double.MIN_VALUE;
		}
		return amount;
	}
	public double withDraw(double withrawalAmount) {
		double amount =0.0;
		if(isLogin && availableAmountInMachine > withrawalAmount) {
			availableAmountInMachine = availableAmountInMachine -withrawalAmount -transactionFee;
			transactionType.add("Withdral");
			transactionAmount.add(withrawalAmount);
			return availableAmountInMachine;
		}
		else {
			amount =Double.MIN_VALUE;
		}
		return amount;
	}
	public double deposit(double depAmount) {
		
		if(isLogin) {
			availableAmountInMachine += depAmount - transactionFee;
			transactionType.add("Deposit");
			transactionAmount.add(depAmount);
		}
		else {
			System.out.println("you need to login");
		}
		return availableAmountInMachine;
	}
	public void recentTransactions() {
		int i=0;
		if(transactionAmount.size()==0 || transactionType.size()==0) {
			System.out.println("no transaction history for this account");
		}
		for(String name :transactionType) {
			System.out.print(name);
			System.out.println("\t\t"+transactionAmount.get(i)); i++;
		}
	}
	public void exit() {
		System.out.println("Good bye");
		System.exit(0);
	}		
}

