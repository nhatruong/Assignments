package registration;

public class Course {
	String name;
	int numberOfStudents;
	Student[] registeredStudent = new Student[10];
	int[] r= new int[10];
	public Course() {
		this.name ="";
		this.numberOfStudents =0;		
	}
	public Course(String name) {
		this.name = name;
		this.numberOfStudents =0;		
	}
	public void setName(String name) {
		this.name =name;
	}
	public void setNumberOfStudent(int studentNumber) {
		this.numberOfStudents = studentNumber;
	}
	public String getName() {
		return this.name;
	}
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}
	public Student[] getStudents() {
		return this.registeredStudent;
	}
	public  boolean isFull() {
		boolean isFull= true;
		
		if(this.getNumberOfStudents() < 10){
			isFull = false;
		}
		return isFull;
	}
	public Student registerStudent(Student s) {
		Student studentSuccessfullyRegister =null;
		if(!isFull()) {
			this.registeredStudent[this.getNumberOfStudents()] =s;
			this.numberOfStudents++;
			studentSuccessfullyRegister =s;
		}
		return studentSuccessfullyRegister;
	}

}
