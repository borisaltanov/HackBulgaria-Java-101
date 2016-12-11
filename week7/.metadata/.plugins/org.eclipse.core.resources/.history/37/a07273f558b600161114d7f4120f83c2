package SortingObjects;

public class Student implements Comparable<Student>{
	private final String firstName;
	private final String thirdName;
	private final double grade;
	
	public Student(String firstName, String thirdName, double grade) {
		this.firstName = firstName;
		this.thirdName = thirdName;
		this.grade = grade;
	}
	
	public String getThirdName() {
		return thirdName;
	}

	public double getGrade() {
		return grade;
	}

	public String getFirstName(){
		return firstName;
	}

	@Override
	public int compareTo(Student o) {
		int result = this.getFirstName().compareToIgnoreCase(o.getFirstName());
		if (result == 0) {
			result = this.getThirdName().compareToIgnoreCase(o.getThirdName());
		}
		return result;
	}
}
