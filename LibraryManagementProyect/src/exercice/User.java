package exercice;

import java.time.LocalDate;

import exceptions.InvalidUserException;

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
	
	public User(String name, String email, String memberNumber, LocalDate registrationDate) throws InvalidUserException {
		this.name = name;
		setEmail(email);
		setMemberNumber(memberNumber);
		this.registrationDate = registrationDate;
	}
	
	/**
	 * Calcular cuantos dias se ha pasado de la fecha de entrega y calcular la fecha de sancion (traducir)
	 * @param days
	 */
	public void sanction(int days) {
		
	}
	
	/**
	 * Cancels all sanctions for the user.
	 */
	public void liftSanction() {
		setSanctioned(false);
	}
	
	/**
	 * Returns a boolean indicating if the user is currently sanctioned. 
	 * @return
	 */
	public boolean isSanction() {
		return this.sanctioned;
	}
	
	@Override
	public String toString() {
		return "User Data [Name: "+name+", Email: "+email+", Member number: "+memberNumber+", Registration date: "
				+registrationDate+", Sanctioned?"+sanctioned+", Sanction end date: "+sanctionEndDate+"]";
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
	public void setEmail(String email) throws InvalidUserException {
		String reg="[a-zA-Z]\\.?[a-zA-Z]@[a-zA-Z]\\.[a-zA-Z]";
		if(email.matches(reg)) {
			this.email = email;
		}else {
			throw new InvalidUserException("Email not valid");
		}
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) throws InvalidUserException {
		String reg="SOC[0-9]{5}";
		if(memberNumber.matches(reg)) {
			this.memberNumber = memberNumber;
		}else{
			throw new InvalidUserException("Member number not valid");
		}
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		String reg="[0-2][0-9]/\\d{2}/\\d{4}|3[0-1]/\\d{2}/\\d{4}";
		LocalDate.parse(reg);
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