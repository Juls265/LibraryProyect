package exercice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.BooknotAvailableException;
import exceptions.InvalidLoanException;
import exceptions.InvalidUserException;
import exceptions.RepeatedUserException;

public class LibraryManager {
	static ArrayList<User> users=new ArrayList<User>();
	static ArrayList<Loan> loans=new ArrayList<Loan>();
	
	/**
	 * Registers a new User into the users ArrayList
	 * @param newUser
	 * @return 
	 * @throws InvalidUserException
	 * @throws RepeatedUserException
	 */
	public LibraryManager registerUser(User newUser) throws InvalidUserException, RepeatedUserException {
		if(users.contains(newUser)) {
			throw new RepeatedUserException("ERROR: The user already exists");
		}else {
			users.add(newUser);
		}
		return null;
	}
	
	/**
	 * Registers a new Loan into the loans ArrayList
	 * @param newLoan
	 * @throws InvalidLoanException
	 * @throws BooknotAvailableException 
	 */
	public void registerLoan(Loan newLoan) throws InvalidLoanException, BooknotAvailableException {
		String bookCode=newLoan.getBookCode();
		if(loans.contains(bookCode)) {
			throw new BooknotAvailableException("ERROR: The book is not available.");
		}else {
			loans.add(newLoan);
		}
	}
	
	/**
	 * Returns boolean. Locates the active loan for the book code and marks it as returned. If overdue, the user is sanctioned (1 day per day of delay).
	 * Throws InvalidLoanException if the return date is before the loan date.
	 * @param bookCode
	 * @param returnDate
	 * @return
	 * @throws InvalidLoanException 
	 */
	public boolean returnBook(String bookCode, LocalDate returnDate) throws InvalidLoanException {
		if(loans.contains(bookCode)) {
			int numLoan=loans.indexOf(bookCode);
			Loan xLoan=loans.get(numLoan);
			
			if(returnDate.isBefore(xLoan.getLoanDate())) {
				throw new InvalidLoanException("Date not valid");
			}else {
				xLoan.setActualReturnDate(returnDate);
				int numUser=users.indexOf(xLoan.getMember());
				User xUser=users.get(numUser);
				if(xLoan.isOverdue()) {
					xUser.setSanctioned(true);
					xUser.sanction(xLoan.calculateDelayDays());
					return false;
				}else {
					return true;
				}//overdue if-else
			}//throw if-else
		}else {
			return false;
		}//book if-else
	}
	
	/**
	 * Finds the user using the memberNumber
	 * @param mumberNumber
	 * @return
	 */
	public User findUser(String mumberNumber) {
		if(users.contains(mumberNumber)) {
			int num=users.indexOf(mumberNumber);
			User foundUser=users.get(num);
			return foundUser;
		}else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Users: "+users+"\nLoans: "+loans;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
}