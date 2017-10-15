package registration;

public class Student {
	String name;
	int id;
	
	public Student() {
		
	}
	public Student(String name, int id) {
		this.name = name; this.id =id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id =id;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public String toString() {
		return "Student name is "+ this.getName() +" and id is "+ this.getId();
	}

}
