package exercice;

import java.time.LocalDate;
import java.util.Scanner;

import exceptions.InvalidLoanException;

public class Loan {
	/*
	 * Attributes: 
	 * bookCode (String): 3 uppercase letters + 4 digits (e.g., LIB0001), bookTitle (String), member (User object): The user making the loan
	 * loanDate (LocalDate), dueDate (LocalDate), actualReturnDate (LocalDate): null if the book hasn't been returned yet.
	 * 
	 * Methods: 
	 * Constructor: Receives bookCode, user, title, and loanDate. If the code is invalid, the title is empty, or the date is null/in the future,
	 * throw an InvalidLoanException. The dueDate is calculated by adding 14 days to the loanDate. 
	 * registerReturn(LocalDate date): Sets the return date. Throws InvalidLoanException if the date is null or prior to the loan date.
	 * calculateDelayDays(): Returns the integer difference between dueDate and actualReturnDate. If not yet returned, use the current date.
	 * Returns zero if there is no delay.
	 * isOverdue(): Boolean. Compares dueDate with the current date. 
	 * toString(): Returns loan details. 
	 */
	private String bookCode;
	private String bookTitle;
	private User libraryMember;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate actualReturnDate;
	
	public Loan(String bookCode, String bookTitle, User member, LocalDate loanDate) throws InvalidLoanException {
		setBookCode(bookCode);
		setBookTitle(bookTitle);
		this.libraryMember = member;
		setLoanDate(loanDate);
		setDueDate(loanDate);
	}
	
	/**
	 * Sets the return date.
	 * Throws InvalidLoanException if the date is null or prior to the loan date.
	 * @param date
	 * @throws InvalidLoanException 
	 */
	public void registerReturn(LocalDate date) throws InvalidLoanException {
		if(date==null) {
			throw new InvalidLoanException("ERROR: Date not entered.");
		}else if (date.isBefore(loanDate)) {
			throw new InvalidLoanException("ERROR: Date not correct.");
		}else {
			setActualReturnDate(date);
		}
	}
	
	/**
	 * Returns the integer difference between dueDate and actualReturnDate. If not yet returned, use the current date.
	 * Returns zero if there is no delay.
	 * @return
	 */
	public int calculateDelayDays() {
		int year,numDays;
		LocalDate today=LocalDate.now();
		if(isOverdue()==false) {
			return 0;
		}else if(actualReturnDate==null) {
			year=dueDate.getYear()-today.getYear();
			numDays=dueDate.getDayOfYear()-today.getDayOfYear();
		}else {
			year=dueDate.getYear()-actualReturnDate.getYear();
			numDays=dueDate.getDayOfYear()-actualReturnDate.getDayOfYear();
		}
		return numDays+(year*365);
	}
	
	/**
	 * Return a boolean. Compares dueDate with the current date.
	 * @return
	 */
	public boolean isOverdue() {
		if(actualReturnDate==null) {
			if(!dueDate.equals(LocalDate.now())) {
				if(dueDate.isAfter(LocalDate.now())) {
					return false;
				}else {
					return true;
				}
			}else {
				return false;
			}
		}else {
			if(!dueDate.equals(actualReturnDate)) {
				if(dueDate.isAfter(actualReturnDate)) {
					return false;
				}else {
					return true;
				}
			}else {
				return false;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Loan [Book code: "+bookCode+", Book title: "+bookTitle+", "+libraryMember+", Loan date: "+loanDate+", Due date: "+dueDate+", Actual return date: "+actualReturnDate+"]";
	}

	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) throws InvalidLoanException {
		String reg="[A-Z]{3}[0-9]{4}";
		if(bookCode.matches(reg)) {
			this.bookCode = bookCode;
		}else {
			throw new InvalidLoanException("ERROR: Code not valid.");
		}
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) throws InvalidLoanException {
		if(bookTitle==null) {
			throw new InvalidLoanException("ERROR: No title given.");
		}else {
			this.bookTitle = bookTitle;
		}
	}

	public User getMember() {
		return libraryMember;
	}
	public void setMember(User member) {
		this.libraryMember = member;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) throws InvalidLoanException {
		if(loanDate==null){
			throw new InvalidLoanException("ERROR: No date given.");
		}else if(loanDate.isAfter(LocalDate.now())) {
			throw new InvalidLoanException("ERROR: Invalid Date.");
		}else {
			this.loanDate = loanDate;
		}
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		dueDate=loanDate.plusDays(14);
		this.dueDate = dueDate;
	}
	
	public LocalDate getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(LocalDate actualReturnDate) {
		if(actualReturnDate==null) {
			this.actualReturnDate=null;
		}else {
			this.actualReturnDate = actualReturnDate;
		}
	}
}