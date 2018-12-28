package browsersetup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingCollection {

	public static void main(String[] args) {

		List<Student> studs = new ArrayList<>();
		studs.add(new Student("P",16));
		studs.add(new Student("Pr",17));
		studs.add(new Student("Pra",18));
		studs.add(new Student("Prat",19));
		studs.add(new Student("Prati",20));
		studs.add(new Student("Pratik",21));
		
		Collections.sort(studs, (s1,s2) -> {
			return s1.rollno > s2.rollno?-1:s1.rollno<s2.rollno?1:0;
		});
	
		for(Student s: studs) {
			System.out.println(s);
		}
	}
	
	
	
}	

class Student {
	
	String name;
	int rollno;
	
	public Student(String name, int rollno) {
	
		this.name = name;
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}
	
	
}
