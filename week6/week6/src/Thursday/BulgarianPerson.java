package Thursday;

public class BulgarianPerson extends Person{
	private String ucn;
	
	public String getUCN() {
		return ucn;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * A - Person
	 * B - BulgarianPerson
	 * A.euals(B) -> true;
	 * B.qquls(A) -> true;
	 */

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		
		if(obj instanceof BulgarianPerson) {
			BulgarianPerson other = (BulgarianPerson) obj;
			if (this.getFirstName().equals(other.getFirstName()) &&
					this.getSecondName().equals(other.getSecondName()) && 
					this.getUCN().equals(other.getUCN())) {
				return true;
			}
		}

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
