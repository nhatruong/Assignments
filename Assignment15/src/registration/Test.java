package registration;

public class Test {

	public static void main(String[] args) {
		
		Course course = new Course("Programming 101");
		for(int i=0; i<= 11; i++) {
			int studentOrder = i +1;
			Student register = course.registerStudent(new Student("student "+ studentOrder, i));
			if(register !=null) {
				System.out.println("Successfully registered "+ register.getName() +
						" in class " + course.getName());				
			}
			else {
				System.out.println("course is full. Contact your advisor");				
			}			
		}		 
	}
}
