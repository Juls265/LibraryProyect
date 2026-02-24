package exercice;

import java.time.LocalDate;

public class User {
	/*
	 * Attributes:
	 * name (String), email (String): Must contain "@" and ".", memberNumber (String): Format "SOC" + 5 digits (e.g., SOC00123)
	 * registrationDate (LocalDate), sanctioned (boolean), sanctionEndDate (LocalDate): Can be null if the user is not sanctioned.
	 * 
	 * Methods:
	 * Constructor: Mandatory parameters: name, email, memberNumber, and registrationDate. If any data is incorrect,
	 * it must throw an InvalidUserException with a specific error message.
	 * sanction(int days): Void. Sets the sanction starting from the current day until the date resulting from adding the specified days to the book's return date. 
	 * liftSanction(): Void. Cancels all sanctions for the user.
	 * isSanctioned(): Returns a boolean indicating if the user is currently sanctioned.
	 * toString(): Overridden from Object; returns a string with the user's data.  
	 */
	
	private String name;
	private String email;
	private String memberNumber;
	private LocalDate registrationDate;
	private boolean sanctioned;
	private LocalDate sanctionEndDate;
	
	public User(String name, String email, String memberNumber, LocalDate registrationDate) {
		this.name = name;
		setEmail(email);
		this.memberNumber = memberNumber;
		this.registrationDate = registrationDate;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String reg="[a-zA-Z].[a-zA-Z]@[a-zA-Z].[a-zA-Z]";
		if(email.equals(reg)) {
			this.email = email;
		}else {
			this.email="Error";
		}
		
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public boolean isSanctioned() {
		return sanctioned;
	}
	public void setSanctioned(boolean sanctioned) {
		this.sanctioned = sanctioned;
	}
	
	public LocalDate getSanctionEndDate() {
		return sanctionEndDate;
	}
	public void setSanctionEndDate(LocalDate sanctionEndDate) {
		this.sanctionEndDate = sanctionEndDate;
	}
}