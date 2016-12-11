package pandaSocialNetwork;

public class Panda {
	private String firstName;
	private String email;
	private String gender;
	
	public Panda(String firstName, String email, String gender) {
		this.firstName = firstName;
		if (validateEmail(email)) {
			this.email = email;
		}
		this.gender = gender;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Panda other = (Panda) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}

	public boolean isMale() {
		return this.getGender() == "male";
	}
	
	public boolean isFemale() {
		return this.getGender() == "female";
	}
	
	private boolean validateEmail(String email) {
		return email.matches("\\S+@\\S+\\.\\S+") && email.length() >= 5;
	}
	
	public String toString() {
		String result = "";
		result += this.getFirstName() + " ";
		result += this.getEmail() + " ";
		result += this.getGender();
		return result;
	}
}
