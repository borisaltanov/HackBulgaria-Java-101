package SortingObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Ivan", "Ivanov", 5));
		students.add(new Student("Ivan", "Borisov", 5));
		students.add(new Student("Peter", "Angelov", 6.0));
		students.add(new Student("John", "Green", 4.6));
		students.add(new Student("Alice", "Green", 5.0));
		students.add(new Student("Angel", "Blue", 3.50));
		
		//Collections.sort(students);
		
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return ((Double)o2.getGrade()).compareTo((Double)o1.getGrade());
			}
			
		});
		for (Student student : students) {
			System.out.println(student.getFirstName() + " " + student.getThirdName() + " " + student.getGrade());
		}
	}

}
