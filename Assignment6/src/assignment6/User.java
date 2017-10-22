package assignment6;

public class User {
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private static int bankAccountNumber=0;
	private int accountNumber;
	//constructor 
	User(String name, int age, String address, String phoneNumber){
		 this.name =name;
		 this.age =age;
		 this.address =address;
		 this.phoneNumber =phoneNumber;
		 accountNumber=++bankAccountNumber;
	 }
	public void setName(String name) {
		this.name =name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age =age;
	}
	public int getAge() {
		return age;
	}
	public void setAddress(String address) {
		this.address =address;
	}
	public String getAddress() {
		return address;
	}
	public void setPhoneNumber(String phone) {
		this.phoneNumber =phone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getBankAccountNumber() {
		return accountNumber;
	}

}
