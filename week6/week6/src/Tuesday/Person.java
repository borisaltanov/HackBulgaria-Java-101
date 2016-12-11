package Tuesday;

public class Person {
	private final String firstName = "Asen";
	private String secondName;
	public int timesAccessed;
	
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getSecondName(){
		if(secondName == null) {
			secondName = "Petrov";
		}
		return secondName;
	}
	
	@Override
	public int hashCode() {
		return getFirstName().hashCode();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		/*if (this.getClass().equals(obj.getClass())){
			Person other = (Person) obj;
			// always use getters
			if (this.getFirstName().equals(other.getFirstName()) && this.secondName.equals(other.secondName)) {
				return true;
			}
		}
		*/
		// tova s naslednika
/*		if(obj instanceof BulgarianPerson) {
			BulgarianPersonPerson other = (Person) obj;
			if (this.getFirstName().equals(other.getFirstName()) && this.secondName.equals(other.secondName)) {
				return true;
			}
			
		} else */
		if(obj instanceof Person) {
			Person other = (Person) obj;
			if (this.getFirstName().equals(other.getFirstName()) && 
					this.getSecondName().equals(other.getSecondName())) {
				return true;
			}
		}
		
		
		return false;
	}
	
}
